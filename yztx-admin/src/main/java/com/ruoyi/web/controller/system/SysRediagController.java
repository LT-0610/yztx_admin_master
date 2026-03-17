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
import com.ruoyi.system.domain.SysRediag;
import com.ruoyi.system.service.ISysRediagService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 复诊信息Controller
 * 
 * @author ruoyi
 * @date 2024-04-03
 */
@RestController
@RequestMapping("/system/rediag")
public class SysRediagController extends BaseController
{
    @Autowired
    private ISysRediagService sysRediagService;

    /**
     * 查询复诊信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:rediag:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysRediag sysRediag)
    {
        startPage();
        System.out.println(sysRediag.getSysDiags());
        List<SysRediag> list = sysRediagService.selectSysRediagList(sysRediag);
        return getDataTable(list);
    }

    /**
     * 导出复诊信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:rediag:export')")
    @Log(title = "复诊信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysRediag sysRediag)
    {
        List<SysRediag> list = sysRediagService.selectSysRediagList(sysRediag);
        ExcelUtil<SysRediag> util = new ExcelUtil<SysRediag>(SysRediag.class);
        util.exportExcel(response, list, "复诊信息数据");
    }

    /**
     * 获取复诊信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:rediag:query')")
    @GetMapping(value = "/{rediagId}")
    public AjaxResult getInfo(@PathVariable("rediagId") Long rediagId)
    {
        return success(sysRediagService.selectSysRediagByRediagId(rediagId));
    }

    /**
     * 新增复诊信息
     */
    @PreAuthorize("@ss.hasPermi('system:rediag:add')")
    @Log(title = "复诊信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysRediag sysRediag)
    {
        return toAjax(sysRediagService.insertSysRediag(sysRediag));
    }

    /**
     * 修改复诊信息
     */
    @PreAuthorize("@ss.hasPermi('system:rediag:edit')")
    @Log(title = "复诊信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysRediag sysRediag)
    {
        return toAjax(sysRediagService.updateSysRediag(sysRediag));
    }

    /**
     * 删除复诊信息
     */
    @PreAuthorize("@ss.hasPermi('system:rediag:remove')")
    @Log(title = "复诊信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{rediagIds}")
    public AjaxResult remove(@PathVariable Long[] rediagIds)
    {
        return toAjax(sysRediagService.deleteSysRediagByRediagIds(rediagIds));
    }
}
