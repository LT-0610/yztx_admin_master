package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysRingtoneMapper;
import com.ruoyi.system.domain.SysRingtone;
import com.ruoyi.system.service.ISysRingtoneService;

/**
 * 用户自定义铃声Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-30
 */
@Service
public class SysRingtoneServiceImpl implements ISysRingtoneService 
{
    @Autowired
    private SysRingtoneMapper sysRingtoneMapper;

    /**
     * 查询用户自定义铃声
     * 
     * @param id 用户自定义铃声主键
     * @return 用户自定义铃声
     */
    @Override
    public SysRingtone selectSysRingtoneById(Long id)
    {
        return sysRingtoneMapper.selectSysRingtoneById(id);
    }

    /**
     * 查询用户自定义铃声列表
     * 
     * @param sysRingtone 用户自定义铃声
     * @return 用户自定义铃声
     */
    @Override
    public List<SysRingtone> selectSysRingtoneList(SysRingtone sysRingtone)
    {
        return sysRingtoneMapper.selectSysRingtoneList(sysRingtone);
    }

    /**
     * 新增用户自定义铃声
     * 
     * @param sysRingtone 用户自定义铃声
     * @return 结果
     */
    @Override
    public int insertSysRingtone(SysRingtone sysRingtone)
    {
        return sysRingtoneMapper.insertSysRingtone(sysRingtone);
    }

    /**
     * 修改用户自定义铃声
     * 
     * @param sysRingtone 用户自定义铃声
     * @return 结果
     */
    @Override
    public int updateSysRingtone(SysRingtone sysRingtone)
    {
        return sysRingtoneMapper.updateSysRingtone(sysRingtone);
    }

    /**
     * 批量删除用户自定义铃声
     * 
     * @param ids 需要删除的用户自定义铃声主键
     * @return 结果
     */
    @Override
    public int deleteSysRingtoneByIds(Long[] ids)
    {
        return sysRingtoneMapper.deleteSysRingtoneByIds(ids);
    }

    /**
     * 删除用户自定义铃声信息
     * 
     * @param id 用户自定义铃声主键
     * @return 结果
     */
    @Override
    public int deleteSysRingtoneById(Long id)
    {
        return sysRingtoneMapper.deleteSysRingtoneById(id);
    }
}
