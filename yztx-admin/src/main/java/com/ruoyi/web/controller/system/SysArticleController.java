package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.redis.RedisCache;
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
import com.ruoyi.system.domain.SysArticle;
import com.ruoyi.system.service.ISysArticleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 药品资讯信息Controller
 *
 * @author ruoyi
 * @date 2024-02-28
 */
@RestController
@RequestMapping("/system/article")
public class SysArticleController extends BaseController {
    @Autowired
    private ISysArticleService sysArticleService;

    //redisTemplate
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询药品资讯信息列表
     */
//    @PreAuthorize("@ss.hasPermi('system:article:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysArticle sysArticle) {
        startPage();
        List<SysArticle> list = sysArticleService.selectSysArticleList(sysArticle);
        return getDataTable(list);
    }

    /**
     * 前台查询药品资讯信息列表
     */
//    @PreAuthorize("@ss.hasPermi('system:article:list')")
    @GetMapping("/list1")
    public TableDataInfo list1(SysArticle sysArticle) {
        List<SysArticle> list = sysArticleService.selectSysArticleList(sysArticle);
        return getDataTable(list);
    }

    /**
     * 查询药品资讯信息列表
     */
    @GetMapping("/listByTitle")
    public TableDataInfo listByTitle(SysArticle sysArticle) {
        startPage();
        List<SysArticle> list = sysArticleService.selectSysArticleList(sysArticle);
        return getDataTable(list);
    }
    /**
     * 导出药品资讯信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:article:export')")
    @Log(title = "药品资讯信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysArticle sysArticle) {
        List<SysArticle> list = sysArticleService.selectSysArticleList(sysArticle);
        ExcelUtil<SysArticle> util = new ExcelUtil<SysArticle>(SysArticle.class);
        util.exportExcel(response, list, "药品资讯信息数据");
    }

    /**
     * 获取药品资讯信息详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:article:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(sysArticleService.selectSysArticleById(id));
    }

    /**
     * 新增药品资讯信息
     */
    @PreAuthorize("@ss.hasPermi('system:article:add')")
    @Log(title = "药品资讯信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysArticle sysArticle) {
        return toAjax(sysArticleService.insertSysArticle(sysArticle));
    }

    /**
     * 修改药品资讯信息
     */
    @PreAuthorize("@ss.hasPermi('system:article:edit')")
    @Log(title = "药品资讯信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysArticle sysArticle) {
        return toAjax(sysArticleService.updateSysArticle(sysArticle));
    }

    /**
     * 删除药品资讯信息
     */
    @PreAuthorize("@ss.hasPermi('system:article:remove')")
    @Log(title = "药品资讯信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(sysArticleService.deleteSysArticleByIds(ids));
    }


    /**
     * 文章阅读量加一
     *
     * @param id 文章id
     * @return
     */
    @PostMapping("/readAdd")
    public AjaxResult incrementReadCount(@RequestParam Long id) {
        if (ObjectUtils.isEmpty(id)){
            return AjaxResult.error("参数传入失败");
        }
        Boolean keyExists = redisTemplate.opsForHash().hasKey(RedisKeyUtils.READING_QUANTITY, id.toString());
        if (!keyExists) {
            redisTemplate.opsForHash().put(RedisKeyUtils.READING_QUANTITY, id.toString(), 0); // Ensure the value is a String
        }
        redisTemplate.opsForHash().increment(RedisKeyUtils.READING_QUANTITY, id.toString(), 1);
        return AjaxResult.success("操作成功");
    }

    /**
     * redis 点赞
     *
     * @param id 文章id
     * @return
     */
    @PostMapping("/like")
    public AjaxResult incrementLikeCount(@RequestParam Long id){
        if (ObjectUtils.isEmpty(id)){
            return AjaxResult.error("参数传入失败");
        }
        //hasKey()非空返回true进入方法  空返回false走else
        Boolean keyExists = redisTemplate.opsForHash().hasKey(RedisKeyUtils.LIKE_QUANTITY, id.toString());
        if (keyExists){
                redisTemplate.opsForHash().increment(RedisKeyUtils.LIKE_QUANTITY, id.toString(), 1);
        }else {
            // 点赞
            redisTemplate.opsForHash().put(RedisKeyUtils.LIKE_QUANTITY, id.toString(), 0);
            // 点赞数+1
            redisTemplate.opsForHash().increment(RedisKeyUtils.LIKE_QUANTITY, id.toString(), 1);
        }
        return AjaxResult.success("操作成功");
    }

    /**
     * redis 取消点赞
     *
     * @param id 文章id
     * @return
     */
    @PostMapping("/cancelLike")
    public AjaxResult decrementLikeCount(@RequestParam Long id){
        if (ObjectUtils.isEmpty(id)){
            return AjaxResult.error("参数传入失败");
        }
        //hasKey()非空返回true进入方法  空返回false走else
        Boolean keyExists = redisTemplate.opsForHash().hasKey(RedisKeyUtils.LIKE_QUANTITY, id.toString());
        if (keyExists){
            redisTemplate.opsForHash().increment(RedisKeyUtils.LIKE_QUANTITY, id.toString(), -1);
        }else {
            // 点赞数-1
            redisTemplate.opsForHash().increment(RedisKeyUtils.LIKE_QUANTITY, id.toString(), -1);
            Long value = (Long) redisTemplate.opsForHash().get(RedisKeyUtils.LIKE_QUANTITY, id.toString());
            if(value<0){
                // 点赞
                redisTemplate.opsForHash().put(RedisKeyUtils.LIKE_QUANTITY, id.toString(), 0);
            }
        }
        return AjaxResult.success("操作成功");
    }

    /**
     * redis 收藏
     *
     * @param id 文章id
     * @return
     */
    @PostMapping("/collect")
    public AjaxResult incrementCollectCount(@RequestParam Long id){
        if (ObjectUtils.isEmpty(id)){
            return AjaxResult.error("参数传入失败");
        }
        //hasKey()非空返回true进入方法  空返回false走else
        Boolean keyExists = redisTemplate.opsForHash().hasKey(RedisKeyUtils.ARTICLE_COLLECT_QUANTITY, id.toString());
        if (keyExists){
            redisTemplate.opsForHash().increment(RedisKeyUtils.ARTICLE_COLLECT_QUANTITY, id.toString(), 1);
        }else {
            // 点赞
            redisTemplate.opsForHash().put(RedisKeyUtils.ARTICLE_COLLECT_QUANTITY, id.toString(), 0);
            // 点赞数+1
            redisTemplate.opsForHash().increment(RedisKeyUtils.ARTICLE_COLLECT_QUANTITY, id.toString(), 1);
        }
        return AjaxResult.success("操作成功");
    }

    /**
     * redis 取消收藏
     *
     * @param id 文章id
     * @return
     */
    @PostMapping("/cancelCollect")
    public AjaxResult decrementCollectCount(@RequestParam Long id){
        if (ObjectUtils.isEmpty(id)){
            return AjaxResult.error("参数传入失败");
        }
        //hasKey()非空返回true进入方法  空返回false走else
        Boolean keyExists = redisTemplate.opsForHash().hasKey(RedisKeyUtils.ARTICLE_COLLECT_QUANTITY, id.toString());
        if (keyExists){
            redisTemplate.opsForHash().increment(RedisKeyUtils.ARTICLE_COLLECT_QUANTITY, id.toString(), -1);
        }else {
            // 收藏数-1
            redisTemplate.opsForHash().increment(RedisKeyUtils.ARTICLE_COLLECT_QUANTITY, id.toString(), -1);
            Long value = (Long) redisTemplate.opsForHash().get(RedisKeyUtils.ARTICLE_COLLECT_QUANTITY, id.toString());
            if(value<0){
                // 收藏
                redisTemplate.opsForHash().put(RedisKeyUtils.ARTICLE_COLLECT_QUANTITY, id.toString(), 0);
            }
        }
        return AjaxResult.success("操作成功");
    }
}

