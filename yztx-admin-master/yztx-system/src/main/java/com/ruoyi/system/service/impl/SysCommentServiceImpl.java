package com.ruoyi.system.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.RedisKeyUtils;
import com.ruoyi.system.domain.SysArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysCommentMapper;
import com.ruoyi.system.domain.SysComment;
import com.ruoyi.system.service.ISysCommentService;

/**
 * 评论区信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-07
 */
@Service("CommentService")
public class SysCommentServiceImpl implements ISysCommentService 
{
    @Autowired
    private SysCommentMapper sysCommentMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    // 辅助方法，将 SysComment 对象转换为 Map
    private Map<String, Object> convertCommentToMap(SysComment sysComment) {
        Map<String, Object> commentMap = new HashMap<>();
        commentMap.put("id", sysComment.getId());
        commentMap.put("content", sysComment.getContent());
        commentMap.put("userId", sysComment.getUserId());
        commentMap.put("nickname", sysComment.getCommentUser().get(0).getNickName());
        commentMap.put("avatar", sysComment.getCommentUser().get(0).getAvatar());
        commentMap.put("level", sysComment.getLevel());
        //返回的接口 日期没有被格式化  因此单独做处理
        commentMap.put("createTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sysComment.getCreateTime()));
        return commentMap;
    }
    /**
     * 根据talkId查询评论列表，并关联查询用户信息
     * @param talkId
     * @return
     */
    @Override
    public List<Map<String, Object>> selectCommentWithUser(String talkId) {
        List<SysComment> sysComments = sysCommentMapper.selectCommentWithUser(talkId);
        List<Map<String, Object>> resultMap = new ArrayList<>(); // 定义返回结果，重新封装返回结果

        // 创建一个 Map 用于存储根评论和对应的子评论
        Map<String, List<Map<String, Object>>> commentMap = new HashMap<>();

        // 第一次循环，将根节点和子节点分组存储
        for (SysComment sysComment : sysComments) {
            if (sysComment.getLevel() == 0) {
                commentMap.put(sysComment.getId(), new ArrayList<>());
            } else {
                // 获取根评论的子评论列表，如果为空则新建一个列表
                List<Map<String, Object>> childList = commentMap.getOrDefault(sysComment.getRootId(), new ArrayList<>());
                childList.add(convertCommentToMap(sysComment));
                commentMap.put(sysComment.getRootId(), childList);
            }
        }

        // 第二次循环，将根评论和对应的子评论组装成所需格式的 Map，并添加到返回结果中
        for (SysComment sysComment : sysComments) {
            if (sysComment.getLevel() == 0) {
                Map<String, Object> rootMap = convertCommentToMap(sysComment);

                List<Map<String, Object>> childList = commentMap.getOrDefault(sysComment.getId(), new ArrayList<>());
                rootMap.put("child", childList);

                resultMap.add(rootMap);
            }
        }
        return resultMap;
    }


    /**
     * 查询评论区信息列表
     * 
     * @param sysComment 评论区信息
     * @return 评论区信息
     */
    @Override
    public List<SysComment> selectSysCommentList(SysComment sysComment)
    {
        return sysCommentMapper.selectSysCommentList(sysComment);
    }

    /**
     * 新增评论区信息
     * 
     * @param sysComment 评论区信息
     * @return 结果
     */
    @Override
    public int insertSysComment(SysComment sysComment)
    {
        sysComment.setCreateTime(DateUtils.getNowDate());
        return sysCommentMapper.insertSysComment(sysComment);
    }

    /**
     * 修改评论区信息
     *
     * @param sysComment 评论区信息
     * @return 结果
     */
    @Override
    public int updateSysComment(SysComment sysComment)
    {
        return sysCommentMapper.updateSysComment(sysComment);
    }

    /**
     * 批量删除评论区信息
     * 
     * @param ids 需要删除的评论区信息主键
     * @return 结果
     */
    @Override
    public int deleteSysCommentByIds(String[] ids)
    {
        return sysCommentMapper.deleteSysCommentByIds(ids);
    }

    /**
     * 删除评论区信息信息
     * 
     * @param id 评论区信息主键
     * @return 结果
     */
    @Override
    public int deleteSysCommentById(String id)
    {
        SysComment sysComment = sysCommentMapper.selectSysCommentById(id);
        //是根评论 删除关联评论
        if (sysComment.getLevel().equals("0")) {
            sysCommentMapper.deleteSysCommentByRootId(sysComment.getId());
        }
        //不是根评论 直接删除
        return sysCommentMapper.deleteSysCommentById(id);
    }

    /**
     * 定时更新点赞量
     */
    @Override
    public void updateLikeCount() {
        Set<String> readKeys = redisTemplate.opsForHash().keys(RedisKeyUtils.COMMENT_LIKE_QUANTITY);
        for (String key : readKeys) {
            SysComment sysComment = new SysComment();
            String value = redisTemplate.opsForHash().get(RedisKeyUtils.COMMENT_LIKE_QUANTITY, key).toString();
            sysComment.setId(key);
            sysComment.setLikeCount(Long.parseLong(value));
            sysCommentMapper.updateSysComment(sysComment);
        }
    }
}
