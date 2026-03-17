package com.ruoyi.web.controller.system;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.RedisKeyUtils;
import com.ruoyi.system.domain.SysArticle;
import com.ruoyi.system.domain.SysRehbVideo;
import com.ruoyi.system.service.ISysRehbVideoService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysVideoFavorite;
import com.ruoyi.system.service.ISysVideoFavoriteService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户视频收藏Controller
 * 
 * @author ruoyi
 * @date 2024-04-06
 */
@RestController
@RequestMapping("/system/videoFavorite")
public class SysVideoFavoriteController extends BaseController
{
    @Autowired
    private ISysVideoFavoriteService sysVideoFavoriteService;
    @Autowired
    private ISysRehbVideoService sysRehbVideoService;
    //redisTemplate
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 获取用户视频收藏详细信息
     */
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId)
    {
        List<SysRehbVideo> sysRehbVideos = new ArrayList<>();
        List<SysVideoFavorite> sysVideoFavorites = sysVideoFavoriteService.selectSysVideoFavoriteByUserId(userId);
        for (SysVideoFavorite sysVideoFavorite : sysVideoFavorites) {
            SysRehbVideo sysRehbVideo = sysRehbVideoService.selectSysRehbVideoByVideoId(sysVideoFavorite.getVideoId());
            sysRehbVideos.add(sysRehbVideo);
        }
        return success(sysRehbVideos);
    }

    /**
     * 新增用户视频收藏
     */
    @PostMapping
    public AjaxResult add(@RequestBody SysVideoFavorite sysVideoFavorite)
    {
        return toAjax(sysVideoFavoriteService.insertSysVideoFavorite(sysVideoFavorite));
    }


    /**
     * 取消用户视频收藏
     */
	@PostMapping("/deleteCollect")
    public AjaxResult remove(@RequestBody SysVideoFavorite sysVideoFavorite)
    {
        Long videoId = sysVideoFavorite.getVideoId();
        Long id = sysVideoFavoriteService.selectSysVideoFavoriteByVideoId(videoId).getId();
        // 收藏数-1
        redisTemplate.opsForHash().increment(RedisKeyUtils.VIDEO_COLLECT_QUANTITY, id.toString(), -1);
        Long value = (Long) redisTemplate.opsForHash().get(RedisKeyUtils.VIDEO_COLLECT_QUANTITY, id.toString());
        if(value<0){
            // 收藏
            redisTemplate.opsForHash().put(RedisKeyUtils.VIDEO_COLLECT_QUANTITY, id.toString(), 0);
        }
        return toAjax(sysVideoFavoriteService.deleteSysVideoFavoriteById(id));
    }
}
