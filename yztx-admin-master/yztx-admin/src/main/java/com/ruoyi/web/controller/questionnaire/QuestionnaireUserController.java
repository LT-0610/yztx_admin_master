package com.ruoyi.web.controller.questionnaire;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.TbQuestionnaireUser;
import com.ruoyi.system.service.ITbQuestionnaireUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 填写问卷管理Controller
 * 
 * @author astar
 * @date 2024-03-01
 */
@RestController
@RequestMapping("/questionnaire/user")
public class QuestionnaireUserController extends BaseController
{
    @Autowired
    private ITbQuestionnaireUserService tbQuestionnaireUserService;

    /**
     * 查询填写问卷管理列表
     */
    @GetMapping("/list")
    public TableDataInfo list(TbQuestionnaireUser tbQuestionnaireUser)
    {
        startPage();
        List<TbQuestionnaireUser> list = tbQuestionnaireUserService.selectTbQuestionnaireUserList(tbQuestionnaireUser);
        return getDataTable(list);
    }

    /**
     * 导出填写问卷管理列表
     */
    @Log(title = "填写问卷管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TbQuestionnaireUser tbQuestionnaireUser)
    {
        List<TbQuestionnaireUser> list = tbQuestionnaireUserService.selectTbQuestionnaireUserList(tbQuestionnaireUser);
        ExcelUtil<TbQuestionnaireUser> util = new ExcelUtil<TbQuestionnaireUser>(TbQuestionnaireUser.class);
        util.exportExcel(response, list, "填写问卷管理数据");
    }

    /**
     * 获取填写问卷管理详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tbQuestionnaireUserService.selectTbQuestionnaireUserById(id));
    }

    /**
     * 新增填写问卷管理
     */
    @Log(title = "填写问卷管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TbQuestionnaireUser tbQuestionnaireUser)
    {
        return toAjax(tbQuestionnaireUserService.insertTbQuestionnaireUser(tbQuestionnaireUser));
    }

    /**
     * 修改填写问卷管理
     */
    @Log(title = "填写问卷管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TbQuestionnaireUser tbQuestionnaireUser)
    {
        return toAjax(tbQuestionnaireUserService.updateTbQuestionnaireUser(tbQuestionnaireUser));
    }

    /**
     * 删除填写问卷管理
     */
    @Log(title = "填写问卷管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tbQuestionnaireUserService.deleteTbQuestionnaireUserByIds(ids));
    }
}
