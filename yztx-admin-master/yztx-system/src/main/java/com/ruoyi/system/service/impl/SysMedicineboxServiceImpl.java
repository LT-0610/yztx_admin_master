package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysMedicineboxMapper;
import com.ruoyi.system.domain.SysMedicinebox;
import com.ruoyi.system.service.ISysMedicineboxService;

/**
 * 药箱信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-13
 */
@Service
public class SysMedicineboxServiceImpl implements ISysMedicineboxService 
{
    @Autowired
    private SysMedicineboxMapper sysMedicineboxMapper;

    /**
     * 查询药箱信息列表
     * 
     * @param sysMedicinebox 药箱信息
     * @return 药箱信息
     */
    @Override
    public List<SysMedicinebox> selectSysMedicineboxList(SysMedicinebox sysMedicinebox)
    {
        return sysMedicineboxMapper.selectSysMedicineboxList(sysMedicinebox);
    }

    /**
     * 新增药箱信息
     * 
     * @param sysMedicinebox 药箱信息
     * @return 结果
     */
    @Override
    public int insertSysMedicinebox(SysMedicinebox sysMedicinebox)
    {
        return sysMedicineboxMapper.insertSysMedicinebox(sysMedicinebox);
    }

    /**
     * 修改药箱信息
     * 
     * @param sysMedicinebox 药箱信息
     * @return 结果
     */
    @Override
    public int updateSysMedicinebox(SysMedicinebox sysMedicinebox)
    {
        return sysMedicineboxMapper.updateSysMedicinebox(sysMedicinebox);
    }

    /**
     * 批量删除药箱信息
     *
     * @param boxCategory 需要删除的药箱名字
     * @param userId 需要删除的用户信息主键
     * @return 结果
     */
    @Override
    public int deleteSysMedicineboxByCategorys(String boxCategory, Long userId)
    {
        return sysMedicineboxMapper.deleteSysMedicineboxByCategorys(boxCategory,userId);
    }


    /**
     * @param medicine   需要删除的药品信息集合
     * @param userId
     * @param boxCategory
     * @return
     */
    @Override
    public int deleteSysMedicineOfBox(String medicine, Long userId, String boxCategory) {
        return sysMedicineboxMapper.deleteSysMedicineOfBox(medicine,userId,boxCategory);
    }

    @Override
    public List<String> findAllDistinctMedicineBoxNames(Long userId) {
        return sysMedicineboxMapper.findAllDistinctMedicineBoxNames(userId);
    }
}
