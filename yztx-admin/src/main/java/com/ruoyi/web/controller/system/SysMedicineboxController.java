package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.SysMedicinebox;
import com.ruoyi.system.service.ISysMedicineboxService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 药箱信息Controller
 * 
 * @author ruoyi
 * @date 2024-04-13
 */
@RestController
@RequestMapping("/system/medicinebox")
public class SysMedicineboxController extends BaseController
{
    @Autowired
    private ISysMedicineboxService sysMedicineboxService;

    /**
     * 查询药箱信息列表
     */
    @GetMapping("/list")
    public AjaxResult list(SysMedicinebox sysMedicinebox)
    {
        List<SysMedicinebox> list = sysMedicineboxService.selectSysMedicineboxList(sysMedicinebox);
        return success(list);
    }

    /**
     * 查询药箱名称列表
     */
    @GetMapping("/nameBoxList")
    public AjaxResult nameBoxList(@RequestParam Long userId)
    {
        List<String> list = sysMedicineboxService.findAllDistinctMedicineBoxNames(userId);
        return success(list);
    }

    /**
     * 导出药箱信息列表
     */
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysMedicinebox sysMedicinebox)
    {
        List<SysMedicinebox> list = sysMedicineboxService.selectSysMedicineboxList(sysMedicinebox);
        ExcelUtil<SysMedicinebox> util = new ExcelUtil<SysMedicinebox>(SysMedicinebox.class);
        util.exportExcel(response, list, "药箱信息数据");
    }

    /**
     * 新增药箱信息
     */
    @PostMapping
    public AjaxResult add(@RequestBody SysMedicinebox sysMedicinebox)
    {
        return toAjax(sysMedicineboxService.insertSysMedicinebox(sysMedicinebox));
    }

    /**
     * 修改药箱信息
     */
    @PutMapping
    public AjaxResult edit(@RequestBody SysMedicinebox sysMedicinebox)
    {
        return toAjax(sysMedicineboxService.updateSysMedicinebox(sysMedicinebox));
    }

    /**
     * 删除药箱信息
     */
	@DeleteMapping("/removeMedicineBox")
    public AjaxResult removeMedicineBox(@RequestParam String boxCategory,@RequestParam Long userId)
    {
        return toAjax(sysMedicineboxService.deleteSysMedicineboxByCategorys(boxCategory,userId));
    }

    /**
     * 删除药品信息
     */
    @DeleteMapping("removeMedicineOfBox")
    public AjaxResult removeMedicineOfBox(@RequestParam String medicine,@RequestParam Long userId,@RequestParam String boxCategory)
    {
        return toAjax(sysMedicineboxService.deleteSysMedicineOfBox(medicine,userId,boxCategory));
    }
}
