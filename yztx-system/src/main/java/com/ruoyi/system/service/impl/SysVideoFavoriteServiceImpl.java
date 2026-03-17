package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.SysArticleFavorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysVideoFavoriteMapper;
import com.ruoyi.system.domain.SysVideoFavorite;
import com.ruoyi.system.service.ISysVideoFavoriteService;

/**
 * 用户视频收藏Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-06
 */
@Service
public class SysVideoFavoriteServiceImpl implements ISysVideoFavoriteService 
{
    @Autowired
    private SysVideoFavoriteMapper sysVideoFavoriteMapper;

    /**
     * 查询用户视频收藏
     * 
     * @param userId 用户视频收藏主键
     * @return 用户视频收藏
     */
    @Override
    public List<SysVideoFavorite> selectSysVideoFavoriteByUserId(Long userId)
    {
        return sysVideoFavoriteMapper.selectSysVideoFavoriteByUserId(userId);
    }

    /**
     * 查询用户文章收藏
     * @param videoId
     * @return
     */
    @Override
    public SysVideoFavorite selectSysVideoFavoriteByVideoId(Long videoId) {
        return sysVideoFavoriteMapper.selectSysVideoFavoriteByVideoId(videoId);
    }


    /**
     * 新增用户视频收藏
     * 
     * @param sysVideoFavorite 用户视频收藏
     * @return 结果
     */
    @Override
    public int insertSysVideoFavorite(SysVideoFavorite sysVideoFavorite)
    {
        return sysVideoFavoriteMapper.insertSysVideoFavorite(sysVideoFavorite);
    }

    /**
     * 删除用户视频收藏信息
     * 
     * @param id 用户视频收藏主键
     * @return 结果
     */
    @Override
    public int deleteSysVideoFavoriteById(Long id)
    {
        return sysVideoFavoriteMapper.deleteSysVideoFavoriteById(id);
    }
}
