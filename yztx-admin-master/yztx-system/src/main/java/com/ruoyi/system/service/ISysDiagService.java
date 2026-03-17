package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysDiag;

/**
 * 病历初诊信息表Service接口
 * 
 * @author ruoyi
 * @date 2024-03-24
 */
public interface ISysDiagService 
{
    /**
     * 查询病历初诊信息表
     * 
     * @param diagId 病历初诊信息表主键
     * @return 病历初诊信息表
     */
    public SysDiag selectSysDiagByDiagId(Long diagId);

    /**
     * 查询病历初诊信息表列表
     * 
     * @param sysDiag 病历初诊信息表
     * @return 病历初诊信息表集合
     */
    public List<SysDiag> selectSysDiagList(SysDiag sysDiag);

    /**
     * 新增病历初诊信息表
     * 
     * @param sysDiag 病历初诊信息表
     * @return 结果
     */
    public int insertSysDiag(SysDiag sysDiag);

    /**
     * 修改病历初诊信息表
     * 
     * @param sysDiag 病历初诊信息表
     * @return 结果
     */
    public int updateSysDiag(SysDiag sysDiag);

    /**
     * 批量删除病历初诊信息表
     * 
     * @param diagIds 需要删除的病历初诊信息表主键集合
     * @return 结果
     */
    public int deleteSysDiagByDiagIds(Long[] diagIds);

    /**
     * 删除病历初诊信息表信息
     * 
     * @param diagId 病历初诊信息表主键
     * @return 结果
     */
    public int deleteSysDiagByDiagId(Long diagId);

    /**
     * 查询全部病历初诊信息
     * @return 结果
     */
    public List<SysDiag> getAllSysDiag();


}
