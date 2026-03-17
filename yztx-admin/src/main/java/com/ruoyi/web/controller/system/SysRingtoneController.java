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
import com.ruoyi.system.domain.SysRingtone;
import com.ruoyi.system.service.ISysRingtoneService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户自定义铃声Controller
 * 
 * @author ruoyi
 * @date 2024-03-30
 */
@RestController
@RequestMapping("/system/ringtone")
public class SysRingtoneController extends BaseController
{
    @Autowired
    private ISysRingtoneService sysRingtoneService;

    /**
     * 查询用户自定义铃声列表
     */
    @PreAuthorize("@ss.hasPermi('system:ringtone:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysRingtone sysRingtone)
    {
        startPage();
        List<SysRingtone> list = sysRingtoneService.selectSysRingtoneList(sysRingtone);
        return getDataTable(list);
    }

    /**
     * 导出用户自定义铃声列表
     */
    @PreAuthorize("@ss.hasPermi('system:ringtone:export')")
    @Log(title = "用户自定义铃声", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysRingtone sysRingtone)
    {
        List<SysRingtone> list = sysRingtoneService.selectSysRingtoneList(sysRingtone);
        ExcelUtil<SysRingtone> util = new ExcelUtil<SysRingtone>(SysRingtone.class);
        util.exportExcel(response, list, "用户自定义铃声数据");
    }

    /**
     * 获取用户自定义铃声详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:ringtone:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysRingtoneService.selectSysRingtoneById(id));
    }

    /**
     * 新增用户自定义铃声
     */
    @PreAuthorize("@ss.hasPermi('system:ringtone:add')")
    @Log(title = "用户自定义铃声", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysRingtone sysRingtone)
    {
        return toAjax(sysRingtoneService.insertSysRingtone(sysRingtone));
    }

    /**
     * 修改用户自定义铃声
     */
    @PreAuthorize("@ss.hasPermi('system:ringtone:edit')")
    @Log(title = "用户自定义铃声", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysRingtone sysRingtone)
    {
        return toAjax(sysRingtoneService.updateSysRingtone(sysRingtone));
    }

    /**
     * 删除用户自定义铃声
     */
    @PreAuthorize("@ss.hasPermi('system:ringtone:remove')")
    @Log(title = "用户自定义铃声", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysRingtoneService.deleteSysRingtoneByIds(ids));
    }
}
