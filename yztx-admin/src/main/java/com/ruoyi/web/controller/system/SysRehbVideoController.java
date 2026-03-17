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
import com.ruoyi.system.domain.SysRehbVideo;
import com.ruoyi.system.service.ISysRehbVideoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 视频信息Controller
 * 
 * @author ruoyi
 * @date 2024-03-18
 */
@RestController
@RequestMapping("/system/video")
public class SysRehbVideoController extends BaseController
{
    @Autowired
    private ISysRehbVideoService sysRehbVideoService;

    //redisTemplate
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询视频信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:video:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysRehbVideo sysRehbVideo)
    {
        startPage();
        List<SysRehbVideo> list = sysRehbVideoService.selectSysRehbVideoList(sysRehbVideo);
        return getDataTable(list);
    }

    /**
     * 前台查询视频信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:video:list')")
    @GetMapping("/list1")
    public TableDataInfo list1(SysRehbVideo sysRehbVideo)
    {
        List<SysRehbVideo> list = sysRehbVideoService.selectSysRehbVideoList(sysRehbVideo);
        return getDataTable(list);
    }

    /**
     * 导出视频信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:video:export')")
    @Log(title = "视频信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysRehbVideo sysRehbVideo)
    {
        List<SysRehbVideo> list = sysRehbVideoService.selectSysRehbVideoList(sysRehbVideo);
        ExcelUtil<SysRehbVideo> util = new ExcelUtil<SysRehbVideo>(SysRehbVideo.class);
        util.exportExcel(response, list, "视频信息数据");
    }

    /**
     * 获取视频信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:video:query')")
    @GetMapping(value = "/{videoId}")
    public AjaxResult getInfo(@PathVariable("videoId") Long videoId)
    {
        return success(sysRehbVideoService.selectSysRehbVideoByVideoId(videoId));
    }

    /**
     * 新增视频信息
     */
    @PreAuthorize("@ss.hasPermi('system:video:add')")
    @Log(title = "视频信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysRehbVideo sysRehbVideo)
    {
        return toAjax(sysRehbVideoService.insertSysRehbVideo(sysRehbVideo));
    }

    /**
     * 修改视频信息
     */
    @PreAuthorize("@ss.hasPermi('system:video:edit')")
    @Log(title = "视频信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysRehbVideo sysRehbVideo)
    {
        return toAjax(sysRehbVideoService.updateSysRehbVideo(sysRehbVideo));
    }

    /**
     * 删除视频信息
     */
    @PreAuthorize("@ss.hasPermi('system:video:remove')")
    @Log(title = "视频信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{videoIds}")
    public AjaxResult remove(@PathVariable Long[] videoIds)
    {
        return toAjax(sysRehbVideoService.deleteSysRehbVideoByVideoIds(videoIds));
    }

    /**
     * redis 收藏
     *
     * @param id 视频id
     * @return
     */
    @PostMapping("/collect")
    public AjaxResult incrementCollectCount(@RequestParam Long id){
        if (ObjectUtils.isEmpty(id)){
            return AjaxResult.error("参数传入失败");
        }
        //hasKey()非空返回true进入方法  空返回false走else
        Boolean keyExists = redisTemplate.opsForHash().hasKey(RedisKeyUtils.VIDEO_COLLECT_QUANTITY, id.toString());
        if (keyExists){
            redisTemplate.opsForHash().increment(RedisKeyUtils.VIDEO_COLLECT_QUANTITY, id.toString(), 1);
        }else {
            // 点赞
            redisTemplate.opsForHash().put(RedisKeyUtils.VIDEO_COLLECT_QUANTITY, id.toString(), 0);
            // 点赞数+1
            redisTemplate.opsForHash().increment(RedisKeyUtils.VIDEO_COLLECT_QUANTITY, id.toString(), 1);
        }
        return AjaxResult.success("操作成功");
    }

    /**
     * redis 取消收藏
     *
     * @param id 视频id
     * @return
     */
    @PostMapping("/cancelCollect")
    public AjaxResult decrementCollectCount(@RequestParam Long id){
        if (ObjectUtils.isEmpty(id)){
            return AjaxResult.error("参数传入失败");
        }
        //hasKey()非空返回true进入方法  空返回false走else
        Boolean keyExists = redisTemplate.opsForHash().hasKey(RedisKeyUtils.VIDEO_COLLECT_QUANTITY, id.toString());
        if (keyExists){
            redisTemplate.opsForHash().increment(RedisKeyUtils.VIDEO_COLLECT_QUANTITY, id.toString(), -1);
        }else {
            // 收藏数-1
            redisTemplate.opsForHash().increment(RedisKeyUtils.VIDEO_COLLECT_QUANTITY, id.toString(), -1);
            Long value = (Long) redisTemplate.opsForHash().get(RedisKeyUtils.VIDEO_COLLECT_QUANTITY, id.toString());
            if(value<0){
                // 收藏
                redisTemplate.opsForHash().put(RedisKeyUtils.VIDEO_COLLECT_QUANTITY, id.toString(), 0);
            }
        }
        return AjaxResult.success("操作成功");
    }

}
