package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysVideoFavorite;

/**
 * 用户视频收藏Service接口
 * 
 * @author ruoyi
 * @date 2024-04-06
 */
public interface ISysVideoFavoriteService 
{
    /**
     * 查询用户视频收藏
     * 
     * @param userId 用户视频收藏主键
     * @return 用户视频收藏
     */
    public List<SysVideoFavorite> selectSysVideoFavoriteByUserId(Long userId);

    /**
     * 查询用户视频收藏
     *
     * @param videoId 用户视频收藏主键
     * @return 用户视频收藏
     */
    public SysVideoFavorite selectSysVideoFavoriteByVideoId(Long videoId);
    /**
     * 新增用户视频收藏
     * 
     * @param sysVideoFavorite 用户视频收藏
     * @return 结果
     */
    public int insertSysVideoFavorite(SysVideoFavorite sysVideoFavorite);

    /**
     * 批量删除用户视频收藏
     * 
     * @param id 需要删除的用户视频收藏主键集合
     * @return 结果
     */
    public int deleteSysVideoFavoriteById(Long id);
}
