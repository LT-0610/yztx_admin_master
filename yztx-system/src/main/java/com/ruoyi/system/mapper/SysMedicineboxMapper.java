package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysMedicinebox;
import org.apache.ibatis.annotations.Param;

/**
 * 药箱信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-13
 */
public interface SysMedicineboxMapper 
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
     * 删除药箱信息
     *
     * @param boxCategory 需要删除的数据集合
     * @param userId
     * @return 结果
     */
    public int deleteSysMedicineboxByCategorys(@Param("boxCategory") String boxCategory, @Param("userId") Long userId);

    /**
     * @param medicine  需要删除的药品信息集合
     * @param userId
     * @param boxCategory
     * @return
     */
    public int deleteSysMedicineOfBox(@Param("medicineName")String medicine, @Param("userId") Long userId, @Param("boxCategory") String boxCategory);

    /**
     * 查询药箱名称
     * @return
     */
    List<String> findAllDistinctMedicineBoxNames(Long userId);
}
