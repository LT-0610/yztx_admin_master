package com.ruoyi.system.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 药箱信息对象 sys_medicinebox
 *
 * @author ruoyi
 * @date 2024-04-13
 */
public class SysMedicinebox {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 药品名称
     */
    @Excel(name = "药品名称")
    private String medicineName;

    /**
     * 药品余量
     */
    @Excel(name = "药品余量")
    private String margin;

    /**
     * 药箱类别
     */
    @Excel(name = "药箱类别")
    private String boxCategory;

    /**
     * 药品过期时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "药品过期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expireTime;

    /**
     * 药品标记
     */
    @Excel(name = "药品标记")
    private String medicineFlag;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String notes;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private Long userId;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMargin(String margin) {
        this.margin = margin;
    }

    public String getMargin() {
        return margin;
    }

    public void setBoxCategory(String boxCategory) {
        this.boxCategory = boxCategory;
    }

    public String getBoxCategory() {
        return boxCategory;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setMedicineFlag(String medicineFlag) {
        this.medicineFlag = medicineFlag;
    }

    public String getMedicineFlag() {
        return medicineFlag;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getNotes() {
        return notes;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("medicineName", getMedicineName())
                .append("margin", getMargin())
                .append("boxCategory", getBoxCategory())
                .append("expireTime", getExpireTime())
                .append("medicineFlag", getMedicineFlag())
                .append("notes", getNotes())
                .append("userId", getUserId())
                .toString();
    }
}
