package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysRediagMapper;
import com.ruoyi.system.domain.SysRediag;
import com.ruoyi.system.service.ISysRediagService;

/**
 * 复诊信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-03
 */
@Service
public class SysRediagServiceImpl implements ISysRediagService 
{
    @Autowired
    private SysRediagMapper sysRediagMapper;

    /**
     * 查询复诊信息
     * 
     * @param rediagId 复诊信息主键
     * @return 复诊信息
     */
    @Override
    public SysRediag selectSysRediagByRediagId(Long rediagId)
    {
        return sysRediagMapper.selectSysRediagByRediagId(rediagId);
    }

    /**
     * 查询复诊信息列表
     * 
     * @param sysRediag 复诊信息
     * @return 复诊信息
     */
    @Override
    public List<SysRediag> selectSysRediagList(SysRediag sysRediag)
    {
        return sysRediagMapper.selectSysRediagList(sysRediag);
    }

    /**
     * 新增复诊信息
     * 
     * @param sysRediag 复诊信息
     * @return 结果
     */
    @Override
    public int insertSysRediag(SysRediag sysRediag)
    {
        return sysRediagMapper.insertSysRediag(sysRediag);
    }

    /**
     * 修改复诊信息
     * 
     * @param sysRediag 复诊信息
     * @return 结果
     */
    @Override
    public int updateSysRediag(SysRediag sysRediag)
    {
        return sysRediagMapper.updateSysRediag(sysRediag);
    }

    /**
     * 批量删除复诊信息
     * 
     * @param rediagIds 需要删除的复诊信息主键
     * @return 结果
     */
    @Override
    public int deleteSysRediagByRediagIds(Long[] rediagIds)
    {
        return sysRediagMapper.deleteSysRediagByRediagIds(rediagIds);
    }

    /**
     * 删除复诊信息信息
     * 
     * @param rediagId 复诊信息主键
     * @return 结果
     */
    @Override
    public int deleteSysRediagByRediagId(Long rediagId)
    {
        return sysRediagMapper.deleteSysRediagByRediagId(rediagId);
    }
}
