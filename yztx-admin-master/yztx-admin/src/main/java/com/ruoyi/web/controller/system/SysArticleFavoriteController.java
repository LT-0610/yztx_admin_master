package com.ruoyi.web.controller.system;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.RedisKeyUtils;
import com.ruoyi.system.domain.SysArticle;
import com.ruoyi.system.service.ISysArticleService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysArticleFavorite;
import com.ruoyi.system.service.ISysArticleFavoriteService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户文章收藏Controller
 * 
 * @author ruoyi
 * @date 2024-04-06
 */
@RestController
@RequestMapping("/system/articleFavorite")
public class SysArticleFavoriteController extends BaseController
{
    @Autowired
    private ISysArticleFavoriteService sysArticleFavoriteService;

    @Autowired
    private ISysArticleService sysArticleService;

    //redisTemplate
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 获取用户文章收藏详细信息
     */
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId)
    {
        List<SysArticle> sysArticles = new ArrayList<>();
        List<SysArticleFavorite> sysArticleFavorites = sysArticleFavoriteService.selectSysArticleFavoriteByUserId(userId);
        for (SysArticleFavorite sysArticleFavorite : sysArticleFavorites) {
            SysArticle sysArticle = sysArticleService.selectSysArticleById(sysArticleFavorite.getArticleId());
            sysArticles.add(sysArticle);
        }
        return success(sysArticles);
    }


    /**
     * 添加用户文章收藏
     */
    @PostMapping
    public AjaxResult add(@RequestBody SysArticleFavorite sysArticleFavorite)
    {
        return toAjax(sysArticleFavoriteService.insertSysArticleFavorite(sysArticleFavorite));
    }


    /**
     * 取消用户文章收藏
     */
	@PostMapping("/deleteCollect")
    public AjaxResult remove(@RequestBody SysArticleFavorite sysArticleFavorite)
    {
        Long articleId = sysArticleFavorite.getArticleId();
        Long id = sysArticleFavoriteService.selectSysArticleFavoriteByArticleId(articleId).getId();
        // 收藏数-1
        redisTemplate.opsForHash().increment(RedisKeyUtils.ARTICLE_COLLECT_QUANTITY, id.toString(), -1);
        Long value = (Long) redisTemplate.opsForHash().get(RedisKeyUtils.ARTICLE_COLLECT_QUANTITY, id.toString());
        if(value<0){
            // 收藏
            redisTemplate.opsForHash().put(RedisKeyUtils.ARTICLE_COLLECT_QUANTITY, id.toString(), 0);
        }
        return toAjax(sysArticleFavoriteService.deleteSysArticleFavoriteById(id));
    }
}
