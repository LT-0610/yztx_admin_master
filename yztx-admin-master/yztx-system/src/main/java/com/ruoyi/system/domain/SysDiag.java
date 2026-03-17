package com.ruoyi.system.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 病历初诊信息表对象 sys_diag
 *
 * @author ruoyi
 * @date 2024-03-24
 */
public class SysDiag extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long diagId;

    /**
     * 病人姓名
     */
    @Excel(name = "病人姓名")
    private String patientName;

    /**
     * 病人电话
     */
    @Excel(name = "病人电话")
    private String patientNumber;

    /**
     * 病历内容
     */
    @Excel(name = "病历内容")
    private String diagContent;

    /**
     * 病历创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "病历创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date diagTime;

    @Excel(name = "用户ID")
    private Long userId;

    public void setDiagId(Long diagId) {
        this.diagId = diagId;
    }

    public Long getDiagId() {
        return diagId;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setDiagContent(String diagContent) {
        this.diagContent = diagContent;
    }

    public String getDiagContent() {
        return diagContent;
    }

    public void setDiagTime(Date diagTime) {
        this.diagTime = diagTime;
    }

    public Date getDiagTime() {
        return diagTime;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("diagId", getDiagId())
                .append("patientName", getPatientName())
                .append("patientNumber", getPatientNumber())
                .append("diagContent", getDiagContent())
                .append("diagTime", getDiagTime())
                .append("userId", getUserId())
                .toString();
    }
}
