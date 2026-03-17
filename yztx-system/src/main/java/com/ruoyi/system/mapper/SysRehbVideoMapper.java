package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.SysArticle;
import com.ruoyi.system.domain.SysRehbVideo;

/**
 * 视频信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-03-18
 */
public interface SysRehbVideoMapper 
{
    /**
     * 查询视频信息
     * 
     * @param videoId 视频信息主键
     * @return 视频信息
     */
    public SysRehbVideo selectSysRehbVideoByVideoId(Long videoId);

    /**
     * 查询视频信息列表
     * 
     * @param sysRehbVideo 视频信息
     * @return 视频信息集合
     */
    public List<SysRehbVideo> selectSysRehbVideoList(SysRehbVideo sysRehbVideo);

    /**
     * 新增视频信息
     * 
     * @param sysRehbVideo 视频信息
     * @return 结果
     */
    public int insertSysRehbVideo(SysRehbVideo sysRehbVideo);

    /**
     * 修改视频信息
     * 
     * @param sysRehbVideo 视频信息
     * @return 结果
     */
    public int updateSysRehbVideo(SysRehbVideo sysRehbVideo);

    /**
     * 删除视频信息
     * 
     * @param videoId 视频信息主键
     * @return 结果
     */
    public int deleteSysRehbVideoByVideoId(Long videoId);

    /**
     * 批量删除视频信息
     * 
     * @param videoIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysRehbVideoByVideoIds(Long[] videoIds);

    /**
     *视频最受欢迎前10名統計
     *按点赞量 收藏量
     */
    public List<SysRehbVideo> CountWithcollect();


}
