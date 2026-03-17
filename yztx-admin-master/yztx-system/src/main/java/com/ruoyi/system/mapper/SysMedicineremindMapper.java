package com.ruoyi.system.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.SysMedicineremind;
import org.apache.ibatis.annotations.MapKey;

/**
 * 用药提醒Mapper接口
 * 
 * @author ruoyi
 * @date 2024-03-10
 */
public interface SysMedicineremindMapper 
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
     * 删除用药提醒
     * 
     * @param id 用药提醒主键
     * @return 结果
     */
    public int deleteSysMedicineremindById(Long id);

    /**
     * 批量删除用药提醒
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysMedicineremindByIds(Long[] ids);

    /**
     * 删除用药提醒
     *
     * @param userId 用药提醒主键
     * @return 结果
     */
    public int deleteSysMedicineremindByUserId(Long userId);

    /**
     * 批量删除用药提醒
     *
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysMedicineremindByUserIds(Long[] userIds);


    /**
     * 统计药品数量使用前五的用户
     * @return
     */
    @MapKey("user_id")
    public List<Map> getTopFiveUsersMedicineCount();

    /**
     * 统计药品数量使用前10的药品
     */
    @MapKey("medicine_name")
    public List<Map> getTopTenMedicineUsage();
}
