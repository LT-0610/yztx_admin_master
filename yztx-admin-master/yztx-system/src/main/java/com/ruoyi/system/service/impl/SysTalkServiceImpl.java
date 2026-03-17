package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysTalkMapper;
import com.ruoyi.system.domain.SysTalk;
import com.ruoyi.system.service.ISysTalkService;

/**
 * 话题信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-07
 */
@Service
public class SysTalkServiceImpl implements ISysTalkService 
{
    @Autowired
    private SysTalkMapper sysTalkMapper;

    /**
     * 查询话题信息
     * 
     * @param id 话题信息主键
     * @return 话题信息
     */
    @Override
    public SysTalk selectSysTalkById(Long id)
    {
        return sysTalkMapper.selectSysTalkById(id);
    }

    /**
     * 查询话题信息列表
     * 
     * @param sysTalk 话题信息
     * @return 话题信息
     */
    @Override
    public List<SysTalk> selectSysTalkList(SysTalk sysTalk)
    {
        return sysTalkMapper.selectSysTalkList(sysTalk);
    }

    /**
     * 新增话题信息
     * 
     * @param sysTalk 话题信息
     * @return 结果
     */
    @Override
    public int insertSysTalk(SysTalk sysTalk)
    {
        return sysTalkMapper.insertSysTalk(sysTalk);
    }

    /**
     * 修改话题信息
     * 
     * @param sysTalk 话题信息
     * @return 结果
     */
    @Override
    public int updateSysTalk(SysTalk sysTalk)
    {
        sysTalk.setUpdateTime(DateUtils.getNowDate());
        return sysTalkMapper.updateSysTalk(sysTalk);
    }

    /**
     * 批量删除话题信息
     * 
     * @param ids 需要删除的话题信息主键
     * @return 结果
     */
    @Override
    public int deleteSysTalkByIds(Long[] ids)
    {
        return sysTalkMapper.deleteSysTalkByIds(ids);
    }

    /**
     * 删除话题信息信息
     * 
     * @param id 话题信息主键
     * @return 结果
     */
    @Override
    public int deleteSysTalkById(Long id)
    {
        return sysTalkMapper.deleteSysTalkById(id);
    }
}
