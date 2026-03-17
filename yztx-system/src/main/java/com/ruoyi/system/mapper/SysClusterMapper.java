package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysCluster;
import org.springframework.stereotype.Repository;

/**
 * 聚类结果信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-06
 */
@Repository
public interface SysClusterMapper 
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



    /**
     * 删除聚类结果信息
     * 
     * @param id 聚类结果信息主键
     * @return 结果
     */
    public int deleteSysClusterById(Long id);

    /**
     * 批量删除聚类结果信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysClusterByIds(Long[] ids);
}
