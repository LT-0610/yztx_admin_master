package com.ruoyi.web.controller.analysis;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.SysArticle;
import com.ruoyi.system.domain.SysMedicineremind;
import com.ruoyi.system.domain.SysRehbVideo;
import com.ruoyi.system.mapper.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据分析接口
 */
@RestController
@RequestMapping("/Analysis")
public class AnalysisController extends BaseController {
    //redisTemplate
    @Autowired
    private SysArticleMapper sysArticleMapper;

    @Autowired
    private SysRehbVideoMapper sysRehbVideoMapper;

    @Autowired
    private SysMedicineremindMapper sysMedicineremindMapper;

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysLogininforMapper sysLogininforMapper;


    /**
     * 最受欢迎文章前10名統計
     * 先按阅读量排序 若相同则按收藏量统计
     *
     * @return
     */
    @GetMapping("/articleCount")
    public AjaxResult getTop10Articles() {
        List<SysArticle> top10Articles = sysArticleMapper.readCountWithcollectWithlike();
        return success(top10Articles);
    }

    /**
     * 最受欢迎视频前10名統計
     * 按收藏量统计
     *
     * @return
     */
    @GetMapping("/videoCount")
    public AjaxResult getTop10Video() {
        List<SysRehbVideo> top10Videos = sysRehbVideoMapper.CountWithcollect();
        return success(top10Videos);
    }


    /**
     * 统计药品使用数量前五的用户
     *
     * @return
     */
    @GetMapping("/medicineCountWithUser")
    public AjaxResult getTopFiveUsersMedicineCount() {
        List<Map> list = sysMedicineremindMapper.getTopFiveUsersMedicineCount();
        for (int i = 0; i < list.size(); i++) {
            Map<Long, Long> map = list.get(i);
            Long userId = map.get("user_id");
            Long count = map.get("count");
            Map<Object, Object> hashMap = new HashMap<>();
            hashMap.put("nick_name", sysUserMapper.selectUserById(userId).getNickName());
            hashMap.put("count", count);
            list.set(i, hashMap); // 替换当前的 map
        }
        return success(list);
    }

    /**
     * 统计药品数量使用前十的药品
     */
    @GetMapping("/medicineUsage")
    public AjaxResult getTopTenMedicineUsage() {
        return success(sysMedicineremindMapper.getTopTenMedicineUsage());
    }

    /**
     * 根据时间段统计活跃用户数(一个月至少登录一天)
     *
     * @param begin
     * @param end
     * @return
     */
    @PostMapping("/userStatistics")
    public AjaxResult usersStatistics(
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime begin,
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime end) {
        Map map = new HashMap();
        map.put("begin", begin);
        map.put("end", end);
        return success(sysLogininforMapper.getMonthlyActiveUsers(map));
    }
    /**
     *按职业统计用户分布
     */
    @GetMapping("/userbycareer")
    public AjaxResult userbyCareer(){
       return success(sysUserMapper.countUsersByCareer());
    }

    /**
     *按地区统计用户分布
     */
    @GetMapping("/userbyarea")
    public AjaxResult userbyArea(){
        return success(sysUserMapper.countUsersByArea());
    }

    /**
     *按性別统计用户分布
     */
    @GetMapping("/userbysex")
    public AjaxResult userbySex(){
        List<Map> list = sysUserMapper.countUsersBySex();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Long> map = list.get(i);
            String sex = String.valueOf(map.get("sex"));
            Map<Object, Object> hashMap = new HashMap<>();
            Long count = map.get("count");
            if(sex.equals("0")){
                hashMap.put("sex", "男");
            }
            else {
                hashMap.put("sex", "女");
            }
            hashMap.put("count", count);
            list.set(i, hashMap); // 替换当前的 map
        }
        return success(list);
    }
    /**
     *按年齡段统计用户分布(18-45岁为青年，46-69岁为中年，69岁以上为老年)
     */
    @GetMapping("/userbyagegroup")
    public AjaxResult userbyAge(){
        return success(sysUserMapper.countUsersByAge());
    }


    /**
     * k均值聚类算法(对年龄进行聚类)
     */


}
