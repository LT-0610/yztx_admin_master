package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Set;

import com.ruoyi.common.utils.RedisKeyUtils;
import com.ruoyi.system.domain.SysArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysRehbVideoMapper;
import com.ruoyi.system.domain.SysRehbVideo;
import com.ruoyi.system.service.ISysRehbVideoService;

/**
 * 视频信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-18
 */
@Service("RehbVideoService")
public class SysRehbVideoServiceImpl implements ISysRehbVideoService 
{
    @Autowired
    private SysRehbVideoMapper sysRehbVideoMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询视频信息
     * 
     * @param videoId 视频信息主键
     * @return 视频信息
     */
    @Override
    public SysRehbVideo selectSysRehbVideoByVideoId(Long videoId)
    {
        return sysRehbVideoMapper.selectSysRehbVideoByVideoId(videoId);
    }

    /**
     * 查询视频信息列表
     * 
     * @param sysRehbVideo 视频信息
     * @return 视频信息
     */
    @Override
    public List<SysRehbVideo> selectSysRehbVideoList(SysRehbVideo sysRehbVideo)
    {
        return sysRehbVideoMapper.selectSysRehbVideoList(sysRehbVideo);
    }

    /**
     * 新增视频信息
     * 
     * @param sysRehbVideo 视频信息
     * @return 结果
     */
    @Override
    public int insertSysRehbVideo(SysRehbVideo sysRehbVideo)
    {
        return sysRehbVideoMapper.insertSysRehbVideo(sysRehbVideo);
    }

    /**
     * 修改视频信息
     * 
     * @param sysRehbVideo 视频信息
     * @return 结果
     */
    @Override
    public int updateSysRehbVideo(SysRehbVideo sysRehbVideo)
    {
        return sysRehbVideoMapper.updateSysRehbVideo(sysRehbVideo);
    }

    /**
     * 批量删除视频信息
     * 
     * @param videoIds 需要删除的视频信息主键
     * @return 结果
     */
    @Override
    public int deleteSysRehbVideoByVideoIds(Long[] videoIds)
    {
        return sysRehbVideoMapper.deleteSysRehbVideoByVideoIds(videoIds);
    }

    /**
     * 删除视频信息信息
     * 
     * @param videoId 视频信息主键
     * @return 结果
     */
    @Override
    public int deleteSysRehbVideoByVideoId(Long videoId)
    {
        return sysRehbVideoMapper.deleteSysRehbVideoByVideoId(videoId);
    }

    /**
     * 定时更新收藏量
     */
    @Override
    public void updateCollectCount() {
        Set<String> readKeys = redisTemplate.opsForHash().keys(RedisKeyUtils.VIDEO_COLLECT_QUANTITY);
        for (String key : readKeys) {
            SysRehbVideo video = new SysRehbVideo();
            String value = redisTemplate.opsForHash().get(RedisKeyUtils.VIDEO_COLLECT_QUANTITY, key).toString();
            video.setVideoId(Long.parseLong(key));
            video.setVideoCollect(Long.parseLong(value));
            sysRehbVideoMapper.updateSysRehbVideo(video);
        }
    }
}
