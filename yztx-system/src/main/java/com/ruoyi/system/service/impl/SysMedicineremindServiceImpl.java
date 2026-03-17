package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysMedicineremindMapper;
import com.ruoyi.system.domain.SysMedicineremind;
import com.ruoyi.system.service.ISysMedicineremindService;

/**
 * 用药提醒Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-10
 */
@Service
public class SysMedicineremindServiceImpl implements ISysMedicineremindService 
{
    @Autowired
    private SysMedicineremindMapper sysMedicineremindMapper;

    /**
     * 查询用药提醒
     * 
     * @param id 用药提醒主键
     * @return 用药提醒
     */
    @Override
    public List<SysMedicineremind> selectSysMedicineremindById(Long id)
    {
        return sysMedicineremindMapper.selectSysMedicineremindById(id);
    }

    /**
     * 查询用药提醒列表
     * 
     * @param sysMedicineremind 用药提醒
     * @return 用药提醒
     */
    @Override
    public List<SysMedicineremind> selectSysMedicineremindList(SysMedicineremind sysMedicineremind)
    {
        return sysMedicineremindMapper.selectSysMedicineremindList(sysMedicineremind);
    }

    /**
     * 新增用药提醒
     * 
     * @param sysMedicineremind 用药提醒
     * @return 结果
     */
    @Override
    public int insertSysMedicineremind(SysMedicineremind sysMedicineremind)
    {
        return sysMedicineremindMapper.insertSysMedicineremind(sysMedicineremind);
    }


    /**
     * 修改用药提醒
     *
     * @param sysMedicineremind 用药提醒
     * @return 结果
     */
    @Override
    public int updateSysMedicineremind(SysMedicineremind sysMedicineremind)
    {
        return sysMedicineremindMapper.updateSysMedicineremind(sysMedicineremind);
    }


    /**
     * 批量删除用药提醒
     * 
     * @param ids 需要删除的用药提醒主键
     * @return 结果
     */
    @Override
    public int deleteSysMedicineremindByIds(Long[] ids)
    {
        return sysMedicineremindMapper.deleteSysMedicineremindByIds(ids);
    }

    /**
     * 删除用药提醒信息
     * 
     * @param id 用药提醒主键
     * @return 结果
     */
    @Override
    public int deleteSysMedicineremindById(Long id)
    {
        return sysMedicineremindMapper.deleteSysMedicineremindById(id);
    }
}
