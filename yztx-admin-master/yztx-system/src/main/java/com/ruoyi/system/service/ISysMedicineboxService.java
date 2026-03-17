package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysMedicinebox;

/**
 * 药箱信息Service接口
 * 
 * @author ruoyi
 * @date 2024-04-13
 */
public interface ISysMedicineboxService 
{

    /**
     * 查询药箱信息列表
     * 
     * @param sysMedicinebox 药箱信息
     * @return 药箱信息集合
     */
    public List<SysMedicinebox> selectSysMedicineboxList(SysMedicinebox sysMedicinebox);

    /**
     * 新增药箱信息
     * 
     * @param sysMedicinebox 药箱信息
     * @return 结果
     */
    public int insertSysMedicinebox(SysMedicinebox sysMedicinebox);

    /**
     * 修改药箱信息
     * 
     * @param sysMedicinebox 药箱信息
     * @return 结果
     */
    public int updateSysMedicinebox(SysMedicinebox sysMedicinebox);

    /**
     * 批量删除药箱信息
     *
     * @param boxCategory 需要删除的药箱信息主键集合
     * @param userId
     * @return 结果
     */
    public int deleteSysMedicineboxByCategorys(String boxCategory, Long userId);

    /**
     * @param medicine   需要删除的药品信息集合
     * @param userId
     * @param boxCategory
     * @return
     */
    public int deleteSysMedicineOfBox(String medicine, Long userId, String boxCategory);

    /**
     * 查询药箱名称
     * @return
     */
    List<String> findAllDistinctMedicineBoxNames(Long userId);
}
