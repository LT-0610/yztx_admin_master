package com.ruoyi.system.domain;

import com.ruoyi.common.core.domain.entity.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;


import java.util.List;

/**
 * 评论区信息对象 sys_comment
 *
 * @author ruoyi
 * @date 2024-04-07
 */
public class SysComment extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private String id;

    /**
     * 评论内容
     */
    @Excel(name = "评论内容")
    private String content;

    /**
     * 话题id
     */
    @Excel(name = "话题id")
    private String talkId;

    /**
     * 评论人id
     */
    @Excel(name = "评论人id")
    private String userId;

    /**
     * 评论层级，0为针对博文的评论，1为针对0的评论，2为针对1的评论
     */
    @Excel(name = "评论层级，0为针对博文的评论，1为针对0的评论，2为针对1的评论")
    private Long level;

    /**
     * 回复的评论id
     */
    @Excel(name = "回复的评论id")
    private String parentId;

    /**
     * 根评论id
     */
    @Excel(name = "根评论id")
    private String rootId;

    /**
     * 是否点赞(1表示点赞 0表示未点赞)
     */
    @Excel(name = "是否点赞(1表示点赞 0表示未点赞)")
    private String isLike;

    /**
     * 点赞数统计
     */
    @Excel(name = "点赞数统计")
    private Long likeCount;

    private List<SysUser> commentUser; // 评论用户信息

    private List<SysUser> replyUser; // 回复用户信息

    public List<SysUser> getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(List<SysUser> commentUser) {
        this.commentUser = commentUser;
    }

    public List<SysUser> getReplyUser() {
        return replyUser;
    }

    public void setReplyUser(List<SysUser> replyUser) {
        this.replyUser = replyUser;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setTalkId(String talkId) {
        this.talkId = talkId;
    }

    public String getTalkId() {
        return talkId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getLevel() {
        return level;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setRootId(String rootId) {
        this.rootId = rootId;
    }

    public String getRootId() {
        return rootId;
    }

    public void setIsLike(String isLike) {
        this.isLike = isLike;
    }

    public String getIsLike() {
        return isLike;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("content", getContent())
                .append("talkId", getTalkId())
                .append("userId", getUserId())
                .append("level", getLevel())
                .append("parentId", getParentId())
                .append("rootId", getRootId())
                .append("isLike", getIsLike())
                .append("likeCount", getLikeCount())
                .append("createTime", getCreateTime())
                .append("commentUser", getCommentUser())
                .append("replyUser", getReplyUser())
                .toString();
    }
}
