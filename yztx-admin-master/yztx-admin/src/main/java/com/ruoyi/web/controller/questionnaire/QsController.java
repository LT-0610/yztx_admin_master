package com.ruoyi.web.controller.questionnaire;


import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ip.IpUtils;
import com.ruoyi.system.domain.TbQuestionnaireUser;
import com.ruoyi.system.service.ITbQuestionnaireService;
import com.ruoyi.system.service.ITbQuestionnaireUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 问卷调查管理Controller
 * 
 * @author astar
 * @date 2024-03-01
 */
@Anonymous
@RestController
@RequestMapping("/qs")
public class QsController extends BaseController
{
    @Autowired
    private ITbQuestionnaireService tbQuestionnaireService;
    @Autowired
    private ITbQuestionnaireUserService tbQuestionnaireUserService;

    /**
     * 获取问卷配置
     * @param url
     * @return {@link AjaxResult}
     */
    @GetMapping("/getQs/{url}")
    public AjaxResult getQs(@PathVariable("url") String url)
    {
        return success(tbQuestionnaireService.getQs(url));
    }
    /**
     * 新增填写问卷管理
     */
    @Log(title = "填写问卷管理", businessType = BusinessType.INSERT)
    @PostMapping("/fillQs")
    public AjaxResult fillQs(@RequestBody TbQuestionnaireUser tbQuestionnaireUser)
    {
        tbQuestionnaireUser.setIpAddr(IpUtils.getIpAddr());
        return toAjax(tbQuestionnaireUserService.insertTbQuestionnaireUser(tbQuestionnaireUser));
    }
}
