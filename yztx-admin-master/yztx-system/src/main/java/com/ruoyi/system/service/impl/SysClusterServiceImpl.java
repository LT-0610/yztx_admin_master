package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysClusterMapper;
import com.ruoyi.system.domain.SysCluster;
import com.ruoyi.system.service.ISysClusterService;

/**
 * 聚类结果信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-06
 */
@Service
public class SysClusterServiceImpl implements ISysClusterService 
{
    @Autowired
    private SysClusterMapper sysClusterMapper;

    /**
     * 查询聚类结果信息
     * 
     * @param id 聚类结果信息主键
     * @return 聚类结果信息
     */
    @Override
    public SysCluster selectSysClusterById(Long id)
    {
        return sysClusterMapper.selectSysClusterById(id);
    }

    /**
     * 查询聚类结果信息列表
     * 
     * @param sysCluster 聚类结果信息
     * @return 聚类结果信息
     */
    @Override
    public List<SysCluster> selectSysClusterList(SysCluster sysCluster)
    {
        return sysClusterMapper.selectSysClusterList(sysCluster);
    }

    /**
     * 新增聚类结果信息
     * 
     * @param sysCluster 聚类结果信息
     * @return 结果
     */
    @Override
    public int insertSysCluster(SysCluster sysCluster)
    {
        sysCluster.setCreateTime(DateUtils.getNowDate());
        return sysClusterMapper.insertSysCluster(sysCluster);
    }
}
