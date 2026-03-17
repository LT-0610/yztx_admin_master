package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 大数据结果数据集对象 test_table
 * 
 * @author ruoyi
 * @date 2024-04-20
 */
public class TestTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String age;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String gender;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String region;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String work;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String isMakeMecicine;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String nameWithValue;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String trustFrequency;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String istoTrust;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String isForget;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String buyMedicineFrequency;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String medicineRegion;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String reason;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String focus;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String isActive;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String channel;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAge(String age) 
    {
        this.age = age;
    }

    public String getAge() 
    {
        return age;
    }
    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }
    public void setRegion(String region) 
    {
        this.region = region;
    }

    public String getRegion() 
    {
        return region;
    }
    public void setWork(String work) 
    {
        this.work = work;
    }

    public String getWork() 
    {
        return work;
    }
    public void setIsMakeMecicine(String isMakeMecicine) 
    {
        this.isMakeMecicine = isMakeMecicine;
    }

    public String getIsMakeMecicine() 
    {
        return isMakeMecicine;
    }
    public void setNameWithValue(String nameWithValue) 
    {
        this.nameWithValue = nameWithValue;
    }

    public String getNameWithValue() 
    {
        return nameWithValue;
    }
    public void setTrustFrequency(String trustFrequency) 
    {
        this.trustFrequency = trustFrequency;
    }

    public String getTrustFrequency() 
    {
        return trustFrequency;
    }
    public void setIstoTrust(String istoTrust) 
    {
        this.istoTrust = istoTrust;
    }

    public String getIstoTrust() 
    {
        return istoTrust;
    }
    public void setIsForget(String isForget) 
    {
        this.isForget = isForget;
    }

    public String getIsForget() 
    {
        return isForget;
    }
    public void setBuyMedicineFrequency(String buyMedicineFrequency) 
    {
        this.buyMedicineFrequency = buyMedicineFrequency;
    }

    public String getBuyMedicineFrequency() 
    {
        return buyMedicineFrequency;
    }
    public void setMedicineRegion(String medicineRegion) 
    {
        this.medicineRegion = medicineRegion;
    }

    public String getMedicineRegion() 
    {
        return medicineRegion;
    }
    public void setReason(String reason) 
    {
        this.reason = reason;
    }

    public String getReason() 
    {
        return reason;
    }
    public void setFocus(String focus) 
    {
        this.focus = focus;
    }

    public String getFocus() 
    {
        return focus;
    }
    public void setIsActive(String isActive) 
    {
        this.isActive = isActive;
    }

    public String getIsActive() 
    {
        return isActive;
    }
    public void setChannel(String channel) 
    {
        this.channel = channel;
    }

    public String getChannel() 
    {
        return channel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("age", getAge())
            .append("gender", getGender())
            .append("region", getRegion())
            .append("work", getWork())
            .append("isMakeMecicine", getIsMakeMecicine())
            .append("nameWithValue", getNameWithValue())
            .append("trustFrequency", getTrustFrequency())
            .append("istoTrust", getIstoTrust())
            .append("isForget", getIsForget())
            .append("buyMedicineFrequency", getBuyMedicineFrequency())
            .append("medicineRegion", getMedicineRegion())
            .append("reason", getReason())
            .append("focus", getFocus())
            .append("isActive", getIsActive())
            .append("channel", getChannel())
            .toString();
    }
}
