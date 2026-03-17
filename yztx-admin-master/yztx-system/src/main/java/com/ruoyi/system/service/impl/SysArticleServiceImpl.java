package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Set;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.RedisKeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysArticleMapper;
import com.ruoyi.system.domain.SysArticle;
import com.ruoyi.system.service.ISysArticleService;

/**
 * 药品资讯信息Service业务层处理
 *
 * @author ruoyi
 * @date 2024-02-28
 */
@Service("ArticleService")
public class SysArticleServiceImpl implements ISysArticleService {
    @Autowired
    private SysArticleMapper sysArticleMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询药品资讯信息
     *
     * @param id 药品资讯信息主键
     * @return 药品资讯信息
     */
    @Override
    public SysArticle selectSysArticleById(Long id) {
        return sysArticleMapper.selectSysArticleById(id);
    }

    /**
     * 查询药品资讯信息列表
     *
     * @param sysArticle 药品资讯信息
     * @return 药品资讯信息
     */
    @Override
    public List<SysArticle> selectSysArticleList(SysArticle sysArticle) {
        return sysArticleMapper.selectSysArticleList(sysArticle);
    }

    /**
     * 根据标签查询药品资讯信息列表
     * @param sysArticle
     * @return
     */
    @Override
    public List<SysArticle> selectSysArticleByTitle(SysArticle sysArticle) {
        return sysArticleMapper.selectSysArticleList(sysArticle);
    }


    /**
     * 新增药品资讯信息
     *
     * @param sysArticle 药品资讯信息
     * @return 结果
     */
    @Override
    public int insertSysArticle(SysArticle sysArticle) {
        sysArticle.setUpdateTime(DateUtils.getNowDate());
        return sysArticleMapper.insertSysArticle(sysArticle);
    }

    /**
     * 修改药品资讯信息
     *
     * @param sysArticle 药品资讯信息
     * @return 结果
     */
    @Override
    public int updateSysArticle(SysArticle sysArticle) {
        sysArticle.setUpdateTime(DateUtils.getNowDate());
        return sysArticleMapper.updateSysArticle(sysArticle);
    }

    /**
     * 批量删除药品资讯信息
     *
     * @param ids 需要删除的药品资讯信息主键
     * @return 结果
     */
    @Override
    public int deleteSysArticleByIds(Long[] ids) {
        return sysArticleMapper.deleteSysArticleByIds(ids);
    }

    /**
     * 删除药品资讯信息信息
     *
     * @param id 药品资讯信息主键
     * @return 结果
     */
    @Override
    public int deleteSysArticleById(Long id) {
        return sysArticleMapper.deleteSysArticleById(id);
    }

    /**
     * 定时更新阅读量
     */
    @Override
    public void updateReadCount() {
        Set<String> readKeys = redisTemplate.opsForHash().keys(RedisKeyUtils.READING_QUANTITY);
        for (String key : readKeys) {
            SysArticle article = new SysArticle();
            String value = redisTemplate.opsForHash().get(RedisKeyUtils.READING_QUANTITY, key).toString();
            article.setId(Long.parseLong(key));
            article.setPageView(Long.parseLong(value));
            sysArticleMapper.updateSysArticle(article);
        }
    }
    /**
     * 定时更新点赞量
     */
    @Override
    public void updateLikeCount() {
        Set<String> readKeys = redisTemplate.opsForHash().keys(RedisKeyUtils.LIKE_QUANTITY);
        for (String key : readKeys) {
            SysArticle article = new SysArticle();
            String value = redisTemplate.opsForHash().get(RedisKeyUtils.LIKE_QUANTITY, key).toString();
            article.setId(Long.parseLong(key));
            article.setPageLike(Long.parseLong(value));
            sysArticleMapper.updateSysArticle(article);
        }
    }


    /**
     * 定时更新收藏量
     */
    @Override
    public void updateCollectCount() {
        Set<String> readKeys = redisTemplate.opsForHash().keys(RedisKeyUtils.ARTICLE_COLLECT_QUANTITY);
        for (String key : readKeys) {
            SysArticle article = new SysArticle();
            String value = redisTemplate.opsForHash().get(RedisKeyUtils.ARTICLE_COLLECT_QUANTITY, key).toString();
            article.setId(Long.parseLong(key));
            article.setPageCollect(Long.parseLong(value));
            sysArticleMapper.updateSysArticle(article);
        }
    }
}
