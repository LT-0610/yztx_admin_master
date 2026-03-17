package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysArticleFavoriteMapper;
import com.ruoyi.system.domain.SysArticleFavorite;
import com.ruoyi.system.service.ISysArticleFavoriteService;

/**
 * 用户文章收藏Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-06
 */
@Service
public class SysArticleFavoriteServiceImpl implements ISysArticleFavoriteService 
{
    @Autowired
    private SysArticleFavoriteMapper sysArticleFavoriteMapper;

    /**
     * 查询用户文章收藏
     * 
     * @param userId 用户文章收藏主键
     * @return 用户文章收藏
     */
    @Override
    public List<SysArticleFavorite> selectSysArticleFavoriteByUserId(Long userId)
    {
        return sysArticleFavoriteMapper.selectSysArticleFavoriteByUserId(userId);
    }

    /**
     * 查询用户文章收藏
     * @param articleId
     * @return
     */
    @Override
    public SysArticleFavorite selectSysArticleFavoriteByArticleId(Long articleId) {
        return sysArticleFavoriteMapper.selectSysArticleFavoriteByArticleId(articleId);
    }


    /**
     * 新增用户文章收藏
     * 
     * @param sysArticleFavorite 用户文章收藏
     * @return 结果
     */
    @Override
    public int insertSysArticleFavorite(SysArticleFavorite sysArticleFavorite)
    {
        return sysArticleFavoriteMapper.insertSysArticleFavorite(sysArticleFavorite);
    }


    /**
     * 批量删除用户文章收藏
     * 
     * @param id 需要删除的用户文章收藏主键
     * @return 结果
     */
    @Override
    public int deleteSysArticleFavoriteById(Long id)
    {
        return sysArticleFavoriteMapper.deleteSysArticleFavoriteById(id);
    }
}
