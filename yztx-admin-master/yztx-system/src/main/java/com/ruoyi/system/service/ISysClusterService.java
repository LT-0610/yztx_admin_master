package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysCluster;

/**
 * 聚类结果信息Service接口
 * 
 * @author ruoyi
 * @date 2024-04-06
 */
public interface ISysClusterService 
{
    /**
     * 查询聚类结果信息
     * 
     * @param id 聚类结果信息主键
     * @return 聚类结果信息
     */
    public SysCluster selectSysClusterById(Long id);

    /**
     * 查询聚类结果信息列表
     * 
     * @param sysCluster 聚类结果信息
     * @return 聚类结果信息集合
     */
    public List<SysCluster> selectSysClusterList(SysCluster sysCluster);

    /**
     * 新增聚类结果信息
     * 
     * @param sysCluster 聚类结果信息
     * @return 结果
     */
    public int insertSysCluster(SysCluster sysCluster);
}
