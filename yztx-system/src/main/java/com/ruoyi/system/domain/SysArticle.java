package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 药品资讯信息对象 sys_article
 *
 * @author ruoyi
 * @date 2024-02-28
 */
public class SysArticle extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 标题名称
     */
    @Excel(name = "标题名称")
    private String title;

    /**
     * 作者
     */
    @Excel(name = "作者")
    private String author;

    /**
     * 封面图片
     */
    private String homePage;

    /** 发布状态 */
    /**
     * 公告状态（0正常 1关闭）
     */
    @Excel(name = "发布状态")
    private String status;

    /**
     * 浏览量
     */
    @Excel(name = "浏览量")
    private Long pageView;

    /**
     * 富文本框,包含图文
     */
    private String imageText;


    /** 文章简介 */
    @Excel(name = "文章简介")
    private String introduction;

    /**
     * 点赞量
     */
    @Excel(name = "点赞量")
    private Long pageLike;

    /**
     * 收藏量
     */
    @Excel(name = "收藏量")
    private Long pageCollect;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setPageView(Long pageView) {
        this.pageView = pageView;
    }

    public Long getPageView() {
        return pageView;
    }

    public void setIntroduction(String introduction)
    {
        this.introduction = introduction;
    }

    public String getIntroduction()
    {
        return introduction;
    }

    public void setImageText(String imageText) {
        this.imageText = imageText;
    }

    public String getImageText() {
        return imageText;
    }

    public void setPageLike(Long pageLike) {
        this.pageLike = pageLike;
    }

    public Long getPageLike() {
        return pageLike;
    }

    public void setPageCollect(Long pageCollect) {
        this.pageCollect = pageCollect;
    }

    public Long getPageCollect() {
        return pageCollect;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("title", getTitle())
                .append("author", getAuthor())
                .append("homePage", getHomePage())
                .append("status", getStatus())
                .append("updateTime", getUpdateTime())
                .append("pageView", getPageView())
                .append("imageText", getImageText())
                .append("pageLike", getPageLike())
                .append("pageCollect", getPageCollect())
                .toString();
    }
}
