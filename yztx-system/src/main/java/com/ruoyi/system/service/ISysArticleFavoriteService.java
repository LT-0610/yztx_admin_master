package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysArticleFavorite;

/**
 * 用户文章收藏Service接口
 * 
 * @author ruoyi
 * @date 2024-04-06
 */
public interface ISysArticleFavoriteService 
{
    /**
     * 查询用户文章收藏
     * 
     * @param userId 用户文章收藏主键
     * @return 用户文章收藏
     */
    public List<SysArticleFavorite> selectSysArticleFavoriteByUserId(Long userId);


    /**
     * 查询用户文章收藏
     * @param articleId
     * @return
     */
    public SysArticleFavorite selectSysArticleFavoriteByArticleId(Long articleId);

    /**
     * 新增用户文章收藏
     * 
     * @param sysArticleFavorite 用户文章收藏
     * @return 结果
     */
    public int insertSysArticleFavorite(SysArticleFavorite sysArticleFavorite);

    /**
     * 批量删除用户文章收藏
     * 
     * @param id 需要删除的用户文章收藏主键
     * @return 结果
     */
    public int deleteSysArticleFavoriteById(Long id);

}
