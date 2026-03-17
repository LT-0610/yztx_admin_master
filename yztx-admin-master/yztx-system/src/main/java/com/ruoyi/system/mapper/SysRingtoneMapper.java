package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysRingtone;

/**
 * 用户自定义铃声Mapper接口
 * 
 * @author ruoyi
 * @date 2024-03-30
 */
public interface SysRingtoneMapper 
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
     * 删除用户自定义铃声
     * 
     * @param id 用户自定义铃声主键
     * @return 结果
     */
    public int deleteSysRingtoneById(Long id);

    /**
     * 删除用户自定义铃声
     *
     * @param userId 用户自定义铃声主键
     * @return 结果
     */
    public int deleteSysRingtoneByUserId(Long userId);

    /**
     * 批量删除用户自定义铃声
     *
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysRingtoneByUserIds(Long[] userIds);

    /**
     * 批量删除用户自定义铃声
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysRingtoneByIds(Long[] ids);
}
