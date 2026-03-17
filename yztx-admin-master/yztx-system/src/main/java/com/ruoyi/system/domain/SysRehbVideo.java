package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 视频信息对象 sys_rehb_video
 *
 * @author ruoyi
 * @date 2024-04-05
 */
public class SysRehbVideo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 视频id */
    private Long videoId;

    /** 视频类型 */
    @Excel(name = "视频类型")
    private String videoType;

    /** 视频名称 */
    @Excel(name = "视频名称")
    private String videoName;

    /** 视频内容 */
    @Excel(name = "视频内容")
    private String videoUrl;

    /** 视频收藏量 */
    @Excel(name = "视频收藏量")
    private Long videoCollect;

    /** 视频简介 */
    @Excel(name = "视频简介")
    private String videoIntroduction;

    /** 视频封面 */
    @Excel(name = "视频封面")
    private String videoCover;

    public void setVideoId(Long videoId)
    {
        this.videoId = videoId;
    }

    public Long getVideoId()
    {
        return videoId;
    }
    public void setVideoType(String videoType)
    {
        this.videoType = videoType;
    }

    public String getVideoType()
    {
        return videoType;
    }
    public void setVideoName(String videoName)
    {
        this.videoName = videoName;
    }

    public String getVideoName()
    {
        return videoName;
    }
    public void setVideoUrl(String videoUrl)
    {
        this.videoUrl = videoUrl;
    }

    public String getVideoUrl()
    {
        return videoUrl;
    }
    public void setVideoCollect(Long videoCollect)
    {
        this.videoCollect = videoCollect;
    }

    public Long getVideoCollect()
    {
        return videoCollect;
    }

    public String getVideoIntroduction() {
        return videoIntroduction;
    }

    public void setVideoIntroduction(String videoIntroduction) {
        this.videoIntroduction = videoIntroduction;
    }

    public void setVideoCover(String videoCover)
    {
        this.videoCover = videoCover;
    }

    public String getVideoCover()
    {
        return videoCover;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("videoId", getVideoId())
                .append("videoType", getVideoType())
                .append("videoName", getVideoName())
                .append("videoUrl", getVideoUrl())
                .append("videoCollect", getVideoCollect())
                .append("videoIntroduction", getVideoIntroduction())
                .append("videoCover", getVideoCover())
                .toString();
    }
}
