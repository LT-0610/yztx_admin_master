package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 话题信息对象 sys_talk
 * 
 * @author ruoyi
 * @date 2024-04-07
 */
public class SysTalk extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 话题主键id */
    private Long id;

    /** 话题标签 */
    @Excel(name = "话题标签")
    private String type;

    /** 话题标题 */
    @Excel(name = "话题标题")
    private String title;

    /** 话题简介 */
    @Excel(name = "话题简介")
    private String introduction;

    /** 封面图片 */
    private String homePage;

    /** 话题内容 */
    @Excel(name = "话题内容")
    private String imageText;

    /** 话题状态（0正常 1关闭） */
    @Excel(name = "话题状态", readConverterExp = "0=正常,1=关闭")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setIntroduction(String introduction) 
    {
        this.introduction = introduction;
    }

    public String getIntroduction() 
    {
        return introduction;
    }
    public void setHomePage(String homePage) 
    {
        this.homePage = homePage;
    }

    public String getHomePage() 
    {
        return homePage;
    }
    public void setImageText(String imageText) 
    {
        this.imageText = imageText;
    }

    public String getImageText() 
    {
        return imageText;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("title", getTitle())
            .append("introduction", getIntroduction())
            .append("homePage", getHomePage())
            .append("imageText", getImageText())
            .append("status", getStatus())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
