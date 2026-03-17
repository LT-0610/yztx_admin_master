package com.ruoyi.system.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.entity.SysRole;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 复诊信息对象 sys_rediag
 *
 * @author ruoyi
 * @date 2024-04-03
 */
public class SysRediag extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long rediagId;

    /**
     * 复诊内容
     */
    @Excel(name = "复诊内容")
    private String rediagContent;

    /**
     * 初诊id
     */
    @Excel(name = "初诊id")
    private Long diagId;

    /**
     * 医院名称
     */
    @Excel(name = "医院名称")
    private String hospitalName;

    /**
     * 提醒时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "提醒时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date rediagTime;


    /** 提醒状态(1是停用 0是正常) */
    @Excel(name = "提醒状态(1是停用 0是正常)")
    private String status;

    /** 提醒方式(0是铃声提醒 1是震动 2是
     铃声和震动提醒) */
    @Excel(name = "提醒方式(0是铃声提醒 1是震动 2是 铃声和震动提醒)")
    private String remindType;

    @Excel(name = "用户ID")
    private Long userId;

    //初诊信息
    private List<SysDiag> sysDiags;




    public List<SysDiag> getSysDiags() {
        return sysDiags;
    }

    public void setSysDiags(List<SysDiag> sysDiags) {
        this.sysDiags = sysDiags;
    }

    public void setRediagId(Long rediagId) {
        this.rediagId = rediagId;
    }

    public Long getRediagId() {
        return rediagId;
    }

    public void setRediagContent(String rediagContent) {
        this.rediagContent = rediagContent;
    }

    public String getRediagContent() {
        return rediagContent;
    }

    public void setDiagId(Long diagId) {
        this.diagId = diagId;
    }

    public Long getDiagId() {
        return diagId;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setRediagTime(Date rediagTime) {
        this.rediagTime = rediagTime;
    }

    public Date getRediagTime() {
        return rediagTime;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setRemindType(String remindType)
    {
        this.remindType = remindType;
    }

    public String getRemindType()
    {
        return remindType;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("rediagId", getRediagId())
                .append("rediagContent", getRediagContent())
                .append("diagId", getDiagId())
                .append("hospitalName", getHospitalName())
                .append("rediagTime", getRediagTime())
                .append("sysDiags", getSysDiags())
                .append("status", getStatus())
                .append("remindType", getRemindType())
                .append("userId", getUserId())
                .toString();
    }
}
