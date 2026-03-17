package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysArticle;

/**
 * 药品资讯信息Service接口
 * 
 * @author ruoyi
 * @date 2024-02-28
 */
public interface ISysArticleService 
{
    /**
     * 查询药品资讯信息
     * 
     * @param id 药品资讯信息主键
     * @return 药品资讯信息
     */
    public SysArticle selectSysArticleById(Long id);

    /**
     * 查询药品资讯信息列表
     * 
     * @param sysArticle 药品资讯信息
     * @return 药品资讯信息集合
     */
    public List<SysArticle> selectSysArticleList(SysArticle sysArticle);

    /**
     * 根据标签查询药品资讯信息列表
     * @param sysArticle
     * @return
     */
    public List<SysArticle> selectSysArticleByTitle(SysArticle sysArticle);

    /**
     * 新增药品资讯信息
     * 
     * @param sysArticle 药品资讯信息
     * @return 结果
     */
    public int insertSysArticle(SysArticle sysArticle);

    /**
     * 修改药品资讯信息
     * 
     * @param sysArticle 药品资讯信息
     * @return 结果
     */
    public int updateSysArticle(SysArticle sysArticle);

    /**
     * 批量删除药品资讯信息
     * 
     * @param ids 需要删除的药品资讯信息主键集合
     * @return 结果
     */
    public int deleteSysArticleByIds(Long[] ids);

    /**
     * 删除药品资讯信息信息
     * 
     * @param id 药品资讯信息主键
     * @return 结果
     */
    public int deleteSysArticleById(Long id);

    /**
     * 定时更新阅读量
     */
    public void updateReadCount();
    /**
     * 定时更新点赞量
     */

    public void updateLikeCount();

    /**
     * 定时更新收藏量
     */
    public void updateCollectCount();
}
