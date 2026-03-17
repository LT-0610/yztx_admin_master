package com.ruoyi.web.controller.system;

import java.util.ArrayList;
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
import com.ruoyi.system.domain.SysMedicineremind;
import com.ruoyi.system.service.ISysMedicineremindService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用药提醒Controller
 * 
 * @author ruoyi
 * @date 2024-03-10
 */
@RestController
@RequestMapping("/system/medicineremind")
public class SysMedicineremindController extends BaseController
{
    @Autowired
    private ISysMedicineremindService sysMedicineremindService;

    /**
     * 查询用药提醒列表
     */
    @PreAuthorize("@ss.hasPermi('system:medicineremind:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysMedicineremind sysMedicineremind)
    {
        startPage();
        List<SysMedicineremind> list = sysMedicineremindService.selectSysMedicineremindList(sysMedicineremind);
        return getDataTable(list);
    }

    /**
     * 导出用药提醒列表
     */
    @PreAuthorize("@ss.hasPermi('system:medicineremind:export')")
    @Log(title = "用药提醒", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysMedicineremind sysMedicineremind)
    {
        List<SysMedicineremind> list = sysMedicineremindService.selectSysMedicineremindList(sysMedicineremind);
        ExcelUtil<SysMedicineremind> util = new ExcelUtil<SysMedicineremind>(SysMedicineremind.class);
        util.exportExcel(response, list, "用药提醒数据");
    }

    /**
     * 获取用药提醒详细信息
     */
//    @PreAuthorize("@ss.hasPermi('system:medicineremind:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysMedicineremindService.selectSysMedicineremindById(id));
    }

    /**
     * 新增用药提醒
     */
    @PreAuthorize("@ss.hasPermi('system:medicineremind:add')")
    @Log(title = "用药提醒", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysMedicineremind sysMedicineremind)
    {
        return toAjax(sysMedicineremindService.insertSysMedicineremind(sysMedicineremind));
    }

    /**
     * 修改用药提醒
     */
//    @PreAuthorize("@ss.hasPermi('system:medicineremind:edit')")
//    @Log(title = "用药提醒", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysMedicineremind sysMedicineremind)
    {

        return toAjax(sysMedicineremindService.updateSysMedicineremind(sysMedicineremind));
    }

    /**
     * 删除用药提醒
     */
    @PreAuthorize("@ss.hasPermi('system:medicineremind:remove')")
    @Log(title = "用药提醒", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysMedicineremindService.deleteSysMedicineremindByIds(ids));
    }


    /**
     * 单次用药量列表
     */
    @GetMapping("/dosageList")
    public AjaxResult dosageList()
    {
        String[] strings = {"0.5","1/3","2/3","1","1.5","2","3",
                "4","5","6","7","8","9","10","适量"};
        String[] strings1 = {"片","粒","滴","袋","丸",
                "喷","揿","吸","贴","杯","克","毫克","微克","毫升"};
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.put("dosage",strings);
        return ajaxResult;
    }
    /**
     * 用药次数列表
     */
    @GetMapping("/frequencyList")
    public AjaxResult frequencyList()
    {
        String[] strings = {"每天1次","每天2次","每天3次","每天4次","饭前(每天3次)",
                "饭后(每天3次)","睡前(每天1次)","每小时","每2小时","每4小时","每8小时","每12小时"};
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.put("frequency",strings);
        return ajaxResult;
    }
    /**
     * 用药天数列表
     */
    @GetMapping("/timeList")
    public AjaxResult timeList()
    {
        String[] strings = {"1天","7天","14天","1个月","2个月",
                "3个月","半年","1年"};
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.put("time",strings);
        return ajaxResult;
    }

}
