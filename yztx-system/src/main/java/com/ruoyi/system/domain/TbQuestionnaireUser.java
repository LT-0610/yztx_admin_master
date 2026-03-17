package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDateTime;

/**
 * 填写问卷管理对象 tb_questionnaire_user
 * 
 * @author astar
 * @date 2024-03-01
 */
public class TbQuestionnaireUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdTime;

    private Long qsId;

    /** 表单配置 */
    @Excel(name = "表单配置")
    private String dataJson;

    /** IP地址 */
    @Excel(name = "IP地址")
    private String ipAddr;
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCreatedTime(LocalDateTime createdTime)
    {
        this.createdTime = createdTime;
    }
    public void setQsId(Long qsId)
    {
        this.qsId = qsId;
    }

    public Long getQsId()
    {
        return qsId;
    }
    public LocalDateTime getCreatedTime()
    {
        return createdTime;
    }
    public void setDataJson(String dataJson) 
    {
        this.dataJson = dataJson;
    }

    public String getDataJson() 
    {
        return dataJson;
    }
    public void setIpAddr(String ipAddr)
    {
        this.ipAddr = ipAddr;
    }

    public String getIpAddr()
    {
        return ipAddr;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createdTime", getCreatedTime())
            .append("dataJson", getDataJson())
            .toString();
    }
}
