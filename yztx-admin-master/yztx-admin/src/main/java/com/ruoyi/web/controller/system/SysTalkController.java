package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.system.domain.SysTalk;
import com.ruoyi.system.service.ISysTalkService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 话题信息Controller
 * 
 * @author ruoyi
 * @date 2024-04-07
 */
@RestController
@RequestMapping("/system/talk")
public class SysTalkController extends BaseController
{
    @Autowired
    private ISysTalkService sysTalkService;

    /**
     * 查询话题信息列表
     */
//    @PreAuthorize("@ss.hasPermi('system:talk:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysTalk sysTalk)
    {
        startPage();
        List<SysTalk> list = sysTalkService.selectSysTalkList(sysTalk);
        return getDataTable(list);
    }

    /**
     * 导出话题信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:talk:export')")
    @Log(title = "话题信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysTalk sysTalk)
    {
        List<SysTalk> list = sysTalkService.selectSysTalkList(sysTalk);
        ExcelUtil<SysTalk> util = new ExcelUtil<SysTalk>(SysTalk.class);
        util.exportExcel(response, list, "话题信息数据");
    }

    /**
     * 获取话题信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:talk:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysTalkService.selectSysTalkById(id));
    }

    /**
     * 新增话题信息
     */
    @PreAuthorize("@ss.hasPermi('system:talk:add')")
    @Log(title = "话题信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysTalk sysTalk)
    {
        return toAjax(sysTalkService.insertSysTalk(sysTalk));
    }

    /**
     * 修改话题信息
     */
    @PreAuthorize("@ss.hasPermi('system:talk:edit')")
    @Log(title = "话题信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysTalk sysTalk)
    {
        return toAjax(sysTalkService.updateSysTalk(sysTalk));
    }

    /**
     * 删除话题信息
     */
    @PreAuthorize("@ss.hasPermi('system:talk:remove')")
    @Log(title = "话题信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysTalkService.deleteSysTalkByIds(ids));
    }
}
