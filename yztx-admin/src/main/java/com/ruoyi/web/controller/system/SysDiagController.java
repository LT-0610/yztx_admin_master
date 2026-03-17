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
import com.ruoyi.system.domain.SysDiag;
import com.ruoyi.system.service.ISysDiagService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 病历初诊信息表Controller
 * 
 * @author ruoyi
 * @date 2024-03-24
 */
@RestController
@RequestMapping("/system/diag")
public class SysDiagController extends BaseController
{
    @Autowired
    private ISysDiagService sysDiagService;

    /**
     * 查询病历初诊信息表列表
     */
    @PreAuthorize("@ss.hasPermi('system:diag:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysDiag sysDiag)
    {
        startPage();
        System.out.println(sysDiag);
        List<SysDiag> list = sysDiagService.selectSysDiagList(sysDiag);
        return getDataTable(list);
    }

    /**
     * 导出病历初诊信息表列表
     */
    @PreAuthorize("@ss.hasPermi('system:diag:export')")
    @Log(title = "病历初诊信息表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysDiag sysDiag)
    {
        List<SysDiag> list = sysDiagService.selectSysDiagList(sysDiag);
        ExcelUtil<SysDiag> util = new ExcelUtil<SysDiag>(SysDiag.class);
        util.exportExcel(response, list, "病历初诊信息表数据");
    }

    /**
     * 获取病历初诊信息表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:diag:query')")
    @GetMapping(value = "/{diagId}")
    public AjaxResult getInfo(@PathVariable("diagId") Long diagId)
    {
        return success(sysDiagService.selectSysDiagByDiagId(diagId));
    }

    /**
     * 新增病历初诊信息表
     */
    @PreAuthorize("@ss.hasPermi('system:diag:add')")
    @Log(title = "病历初诊信息表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysDiag sysDiag)
    {
        return toAjax(sysDiagService.insertSysDiag(sysDiag));
    }

    /**
     * 修改病历初诊信息表
     */
    @PreAuthorize("@ss.hasPermi('system:diag:edit')")
    @Log(title = "病历初诊信息表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysDiag sysDiag)
    {
        return toAjax(sysDiagService.updateSysDiag(sysDiag));
    }

    /**
     * 删除病历初诊信息表
     */
    @PreAuthorize("@ss.hasPermi('system:diag:remove')")
    @Log(title = "病历初诊信息表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{diagIds}")
    public AjaxResult remove(@PathVariable Long[] diagIds)
    {
        int cnt = sysDiagService.deleteSysDiagByDiagIds(diagIds);
        if(cnt==0){
            return error("你删除的初诊信息中有复诊信息关联,请先将关联的复诊信息删除!");
        }
        return success();
    }

}
