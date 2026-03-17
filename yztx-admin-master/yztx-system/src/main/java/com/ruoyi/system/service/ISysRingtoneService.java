package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysRingtone;

/**
 * 用户自定义铃声Service接口
 * 
 * @author ruoyi
 * @date 2024-03-30
 */
public interface ISysRingtoneService 
{
    /**
     * 查询用户自定义铃声
     * 
     * @param id 用户自定义铃声主键
     * @return 用户自定义铃声
     */
    public SysRingtone selectSysRingtoneById(Long id);

    /**
     * 查询用户自定义铃声列表
     * 
     * @param sysRingtone 用户自定义铃声
     * @return 用户自定义铃声集合
     */
    public List<SysRingtone> selectSysRingtoneList(SysRingtone sysRingtone);

    /**
     * 新增用户自定义铃声
     * 
     * @param sysRingtone 用户自定义铃声
     * @return 结果
     */
    public int insertSysRingtone(SysRingtone sysRingtone);

    /**
     * 修改用户自定义铃声
     * 
     * @param sysRingtone 用户自定义铃声
     * @return 结果
     */
    public int updateSysRingtone(SysRingtone sysRingtone);

    /**
     * 批量删除用户自定义铃声
     * 
     * @param ids 需要删除的用户自定义铃声主键集合
     * @return 结果
     */
    public int deleteSysRingtoneByIds(Long[] ids);

    /**
     * 删除用户自定义铃声信息
     * 
     * @param id 用户自定义铃声主键
     * @return 结果
     */
    public int deleteSysRingtoneById(Long id);
}
