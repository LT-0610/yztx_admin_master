package com.ruoyi.system.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.SysComment;

/**
 * 评论区信息Service接口
 * 
 * @author ruoyi
 * @date 2024-04-07
 */
public interface ISysCommentService 
{

    /**
     * 根据talkId查询评论列表，并关联查询用户信息
     * @param talkId
     * @return
     */
    List<Map<String, Object>> selectCommentWithUser(String talkId);

    /**
     * 查询评论区信息列表
     * 
     * @param sysComment 评论区信息
     * @return 评论区信息集合
     */
    public List<SysComment> selectSysCommentList(SysComment sysComment);

    /**
     * 新增评论区信息
     * 
     * @param sysComment 评论区信息
     * @return 结果
     */
    public int insertSysComment(SysComment sysComment);

    /**
     * 修改评论区信息
     *
     * @param sysComment 评论区信息
     * @return 结果
     */
    public int updateSysComment(SysComment sysComment);

    /**
     * 批量删除评论区信息
     * 
     * @param ids 需要删除的评论区信息主键集合
     * @return 结果
     */
    public int deleteSysCommentByIds(String[] ids);

    /**
     * 删除评论区信息信息
     * 
     * @param id 评论区信息主键
     * @return 结果
     */
    public int deleteSysCommentById(String id);


    /**
     * 定时更新点赞量
     */

    public void updateLikeCount();
}
