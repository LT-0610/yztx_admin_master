package com.ruoyi.system.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDateTime;

/**
 * 问卷调查管理对象 tb_questionnaire
 * 
 * @author astar
 * @date 2024-03-01
 */
public class TbQuestionnaire extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdTime;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createdBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedTime;

    /** 更新人 */
    @Excel(name = "更新人")
    private String updatedBy;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 表单配置 */
    @Excel(name = "表单配置")
    private String formJson;

    /** 表单地址 */
    @Excel(name = "表单地址")
    private String formUrl;

    /** 表单状态：false未发布，true已发布 */
    @Excel(name = "表单状态：false未发布，true已发布")
    private Boolean status;

    @Excel(name = "描述")
    private String remark;

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

    public LocalDateTime getCreatedTime()
    {
        return createdTime;
    }
    public void setCreatedBy(String createdBy) 
    {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() 
    {
        return createdBy;
    }
    public void setUpdatedTime(LocalDateTime updatedTime)
    {
        this.updatedTime = updatedTime;
    }

    public LocalDateTime getUpdatedTime()
    {
        return updatedTime;
    }
    public void setUpdatedBy(String updatedBy) 
    {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedBy() 
    {
        return updatedBy;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setFormJson(String formJson) 
    {
        this.formJson = formJson;
    }

    public String getFormJson() 
    {
        return formJson;
    }
    public void setFormUrl(String formUrl) 
    {
        this.formUrl = formUrl;
    }

    public String getFormUrl() 
    {
        return formUrl;
    }
    public void setStatus(Boolean status)
    {
        this.status = status;
    }

    public Boolean getStatus()
    {
        return status;
    }
    public void setRemark(String remark)
    {
        this.remark = remark;
    }
    public String getRemark()
    {
        return remark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createdTime", getCreatedTime())
            .append("createdBy", getCreatedBy())
            .append("updatedTime", getUpdatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("title", getTitle())
            .append("formJson", getFormJson())
            .append("formUrl", getFormUrl())
            .append("status", getStatus())
            .append("remark", getRemark())
            .toString();
    }
}
