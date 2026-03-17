package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.RedisKeyUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysComment;
import com.ruoyi.system.service.ISysCommentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 评论区信息Controller
 * 
 * @author ruoyi
 * @date 2024-04-07
 */
@RestController
@RequestMapping("/system/comment")
public class SysCommentController extends BaseController
{
    @Autowired
    private ISysCommentService sysCommentService;

    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 获取评论区信息详细信息
     */
    @GetMapping(value = "/talkId/{talkId}")
    public AjaxResult selectCommentWithUser(@PathVariable("talkId") Long talkId)
    {
        return success(sysCommentService.selectCommentWithUser(talkId.toString()));
    }
    /**
     * 查询评论区信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:comment:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysComment sysComment)
    {
        startPage();
        List<SysComment> list = sysCommentService.selectSysCommentList(sysComment);
        return getDataTable(list);
    }

    /**
     * 导出评论区信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:comment:export')")
    @Log(title = "评论区信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysComment sysComment)
    {
        List<SysComment> list = sysCommentService.selectSysCommentList(sysComment);
        ExcelUtil<SysComment> util = new ExcelUtil<SysComment>(SysComment.class);
        util.exportExcel(response, list, "评论区信息数据");
    }

    /**
     * 新增评论区信息
     * 0表示针对博文的评论(根评论) root_id为空 parent_id也为空
     * talkId是博文的id(用来区分属于评论属于哪一篇博文)
     * 1为针对0的评论，2为针对1的评论以此类推
     * userId是评论人的id parenId是回复评论的id(指的是回复哪一条评论(id))
     * isLike表示这条评论有没有被人点赞
     */
    @PreAuthorize("@ss.hasPermi('system:comment:add')")
    @Log(title = "评论区信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysComment sysComment)
    {
        return toAjax(sysCommentService.insertSysComment(sysComment));
    }

    /**
     * 修改评论区信息
     * isLike (1表示点赞 0表示未点赞)
     * 点赞量定时更新 不用传
     */
    @PutMapping
    public AjaxResult edit(@RequestBody SysComment sysComment)
    {
        return toAjax(sysCommentService.updateSysComment(sysComment));
    }

    /**
     * redis 点赞
     *
     * @param id 评论id
     * @return
     */
    @PostMapping("/like")
    public AjaxResult incrementLikeCount(@RequestParam Long id){
        if (ObjectUtils.isEmpty(id)){
            return AjaxResult.error("参数传入失败");
        }
        //hasKey()非空返回true进入方法  空返回false走else
        Boolean keyExists = redisTemplate.opsForHash().hasKey(RedisKeyUtils.COMMENT_LIKE_QUANTITY, id.toString());
        if (keyExists){
            redisTemplate.opsForHash().increment(RedisKeyUtils.COMMENT_LIKE_QUANTITY, id.toString(), 1);
        }else {
            // 点赞
            redisTemplate.opsForHash().put(RedisKeyUtils.COMMENT_LIKE_QUANTITY, id.toString(), 0);
            // 点赞数+1
            redisTemplate.opsForHash().increment(RedisKeyUtils.COMMENT_LIKE_QUANTITY, id.toString(), 1);
        }
        return AjaxResult.success("操作成功");
    }

    /**
     * redis 取消点赞
     *
     * @param id 评论id
     * @return
     */
    @PostMapping("/cancelLike")
    public AjaxResult decrementLikeCount(@RequestParam Long id){
        if (ObjectUtils.isEmpty(id)){
            return AjaxResult.error("参数传入失败");
        }
        //hasKey()非空返回true进入方法  空返回false走else
        Boolean keyExists = redisTemplate.opsForHash().hasKey(RedisKeyUtils.COMMENT_LIKE_QUANTITY, id.toString());
        if (keyExists){
            redisTemplate.opsForHash().increment(RedisKeyUtils.COMMENT_LIKE_QUANTITY, id.toString(), -1);
        }else {
            // 点赞数-1
            redisTemplate.opsForHash().increment(RedisKeyUtils.COMMENT_LIKE_QUANTITY, id.toString(), -1);
            Long value = (Long) redisTemplate.opsForHash().get(RedisKeyUtils.COMMENT_LIKE_QUANTITY, id.toString());
            if(value<0){
                // 点赞
                redisTemplate.opsForHash().put(RedisKeyUtils.COMMENT_LIKE_QUANTITY, id.toString(), 0);
            }
        }
        return AjaxResult.success("操作成功");
    }

    /**
     * 删除评论区信息(单条评论 和 根评论) 都能删除
     * 小程序
     */
    @DeleteMapping("/{id}")
    public AjaxResult remove(@PathVariable Long id)
    {
        return toAjax(sysCommentService.deleteSysCommentById(id.toString()));
    }

    /**
     * 删除评论区信息(后台)
     */
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(sysCommentService.deleteSysCommentByIds(ids));
    }


}
