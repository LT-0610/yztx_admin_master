package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysMedicineremind;

/**
 * 用药提醒Service接口
 * 
 * @author ruoyi
 * @date 2024-03-10
 */
public interface ISysMedicineremindService 
{
    /**
     * 查询用药提醒
     * 
     * @param id 用药提醒主键
     * @return 用药提醒
     */
    public List<SysMedicineremind> selectSysMedicineremindById(Long id);

    /**
     * 查询用药提醒列表
     * 
     * @param sysMedicineremind 用药提醒
     * @return 用药提醒集合
     */
    public List<SysMedicineremind> selectSysMedicineremindList(SysMedicineremind sysMedicineremind);

    /**
     * 新增用药提醒
     * 
     * @param sysMedicineremind 用药提醒
     * @return 结果
     */
    public int insertSysMedicineremind(SysMedicineremind sysMedicineremind);


    /**
     * 修改用药提醒
     *
     * @param sysMedicineremind 用药提醒
     * @return 结果
     */
    public int updateSysMedicineremind(SysMedicineremind sysMedicineremind);

    /**
     * 批量删除用药提醒
     * 
     * @param ids 需要删除的用药提醒主键集合
     * @return 结果
     */
    public int deleteSysMedicineremindByIds(Long[] ids);

    /**
     * 删除用药提醒信息
     * 
     * @param id 用药提醒主键
     * @return 结果
     */
    public int deleteSysMedicineremindById(Long id);
}
