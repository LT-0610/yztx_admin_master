package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 聚类结果信息对象 sys_cluster
 * 
 * @author ruoyi
 * @date 2024-04-06
 */
public class SysCluster extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 聚类名称 */
    @Excel(name = "聚类名称")
    private String clusterName;

    /** 聚类结果集 */
    private String clusterResult;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setClusterName(String clusterName) 
    {
        this.clusterName = clusterName;
    }

    public String getClusterName() 
    {
        return clusterName;
    }
    public void setClusterResult(String clusterResult) 
    {
        this.clusterResult = clusterResult;
    }

    public String getClusterResult() 
    {
        return clusterResult;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("clusterName", getClusterName())
            .append("clusterResult", getClusterResult())
            .append("createTime", getCreateTime())
            .toString();
    }
}
