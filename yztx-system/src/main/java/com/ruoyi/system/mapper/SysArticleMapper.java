package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysArticle;

/**
 * 药品资讯信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-02-28
 */
public interface SysArticleMapper 
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
     * 删除药品资讯信息
     * 
     * @param id 药品资讯信息主键
     * @return 结果
     */
    public int deleteSysArticleById(Long id);

    /**
     * 批量删除药品资讯信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysArticleByIds(Long[] ids);

    /**
     *文章最受欢迎前10名統計
     *按点赞量 收藏量 阅读量 排序
     */
    public List<SysArticle> readCountWithcollectWithlike();
}
