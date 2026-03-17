package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.aliyun.oss.common.utils.DateUtil;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysRediag;
import com.ruoyi.system.mapper.SysRediagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysDiagMapper;
import com.ruoyi.system.domain.SysDiag;
import com.ruoyi.system.service.ISysDiagService;

/**
 * 病历初诊信息表Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-03-24
 */
@Service
public class SysDiagServiceImpl implements ISysDiagService 
{
    @Autowired
    private SysDiagMapper sysDiagMapper;

    @Autowired
    private SysRediagMapper sysRediagMapper;
    /**
     * 查询病历初诊信息表
     * 
     * @param diagId 病历初诊信息表主键
     * @return 病历初诊信息表
     */
    @Override
    public SysDiag selectSysDiagByDiagId(Long diagId)
    {
        return sysDiagMapper.selectSysDiagByDiagId(diagId);
    }

    /**
     * 查询病历初诊信息表列表
     * 
     * @param sysDiag 病历初诊信息表
     * @return 病历初诊信息表
     */
    @Override
    public List<SysDiag> selectSysDiagList(SysDiag sysDiag)
    {
        return sysDiagMapper.selectSysDiagList(sysDiag);
    }

    /**
     * 新增病历初诊信息表
     * 
     * @param sysDiag 病历初诊信息表
     * @return 结果
     */
    @Override
    public int insertSysDiag(SysDiag sysDiag)
    {
        sysDiag.setDiagTime(DateUtils.getNowDate());
        return sysDiagMapper.insertSysDiag(sysDiag);
    }

    /**
     * 修改病历初诊信息表
     * 
     * @param sysDiag 病历初诊信息表
     * @return 结果
     */
    @Override
    public int updateSysDiag(SysDiag sysDiag)
    {
        sysDiag.setDiagTime(DateUtils.getNowDate());
        return sysDiagMapper.updateSysDiag(sysDiag);
    }

    /**
     * 批量删除病历初诊信息表
     * 
     * @param diagIds 需要删除的病历初诊信息表主键
     * @return 结果
     */
    @Override
    public int deleteSysDiagByDiagIds(Long[] diagIds)
    {
        List<List<SysRediag>> list = new ArrayList<>();
        for (Long diagId : diagIds) {
            List<SysRediag> sysRediags = sysRediagMapper.selectSysRediagBydiagId(diagId);
            if (!StringUtils.isNull(sysRediags)) {
                list.add(sysRediags);
            }
        }
        if (list.size()>0){
            return 0;
        }
        else {
            return sysDiagMapper.deleteSysDiagByDiagIds(diagIds);
        }
    }

    /**
     * 删除病历初诊信息表信息
     * 
     * @param diagId 病历初诊信息表主键
     * @return 结果
     */
    @Override
    public int deleteSysDiagByDiagId(Long diagId)
    {
        return sysDiagMapper.deleteSysDiagByDiagId(diagId);
    }

    @Override
    public List<SysDiag> getAllSysDiag() {
        return sysDiagMapper.getAllSysDiag();
    }
}
