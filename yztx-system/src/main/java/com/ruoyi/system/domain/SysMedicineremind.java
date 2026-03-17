package com.ruoyi.system.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用药提醒对象 sys_medicineremind
 *
 * @author ruoyi
 * @date 2024-03-10
 */
public class SysMedicineremind extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户ID
     */
    @Excel(name = "用户ID")
    private Long userId;

    /**
     * 药品名称
     */
    @Excel(name = "药品名称")
    private String medicineName;

    /**
     * 单次用量
     */
    @Excel(name = "单次用量")
    private String dosage;

    /**
     * 药品次数
     */
    @Excel(name = "药品次数")
    private String frequency;

    /**
     * 用药天数
     */
    @Excel(name = "用药天数")
    private String medicineDays;

    /**
     * 早上提醒时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "早上提醒时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date morningTime;

    /**
     * 中午提醒时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "中午提醒时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date noonTime;

    /**
     * 晚上提醒时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "晚上提醒时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date eveningTime;

    /**
     * 提醒状态(1是停用 0是正常)
     */
    @Excel(name = "提醒状态(1是停用 0是正常)")
    private String status;

    /**
     * 提醒方式(0是铃声提醒 1是震动 2是
     * 铃声和震动提醒)
     */
    @Excel(name = "提醒方式(0是铃声提醒 1是震动 2是 铃声和震动提醒)")
    private String remindType;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getDosage() {
        return dosage;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setMedicineDays(String medicineDays) {
        this.medicineDays = medicineDays;
    }

    public String getMedicineDays() {
        return medicineDays;
    }

    public void setMorningTime(Date morningTime) {
        this.morningTime = morningTime;
    }

    public Date getMorningTime() {
        return morningTime;
    }

    public void setNoonTime(Date noonTime) {
        this.noonTime = noonTime;
    }

    public Date getNoonTime() {
        return noonTime;
    }

    public void setEveningTime(Date eveningTime) {
        this.eveningTime = eveningTime;
    }

    public Date getEveningTime() {
        return eveningTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setRemindType(String remindType) {
        this.remindType = remindType;
    }

    public String getRemindType() {
        return remindType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("userId", getUserId())
                .append("medicineName", getMedicineName())
                .append("dosage", getDosage())
                .append("frequency", getFrequency())
                .append("morningTime", getMorningTime())
                .append("noonTime", getNoonTime())
                .append("eveningTime", getEveningTime())
                .append("createTime", getCreateTime())
                .append("status", getStatus())
                .append("remindType", getRemindType())
                .toString();
    }
}
