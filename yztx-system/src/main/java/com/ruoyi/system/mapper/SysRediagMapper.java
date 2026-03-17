package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysRediag;

/**
 * 复诊信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-03
 */
public interface SysRediagMapper 
{
    /**
     * 查询复诊信息
     * 
     * @param rediagId 复诊信息主键
     * @return 复诊信息
     */
    public SysRediag selectSysRediagByRediagId(Long rediagId);

    /**
     * 查询复诊信息列表
     * 
     * @param sysRediag 复诊信息
     * @return 复诊信息集合
     */
    public List<SysRediag> selectSysRediagList(SysRediag sysRediag);

    /**
     * 新增复诊信息
     * 
     * @param sysRediag 复诊信息
     * @return 结果
     */
    public int insertSysRediag(SysRediag sysRediag);

    /**
     * 修改复诊信息
     * 
     * @param sysRediag 复诊信息
     * @return 结果
     */
    public int updateSysRediag(SysRediag sysRediag);

    /**
     * 删除复诊信息
     * 
     * @param rediagId 复诊信息主键
     * @return 结果
     */
    public int deleteSysRediagByRediagId(Long rediagId);

    /**
     * 批量删除复诊信息
     * 
     * @param rediagIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysRediagByRediagIds(Long[] rediagIds);

    /**
     * 根据初诊id查复诊信息
     * @param diagId
     * @return
     */
    List<SysRediag> selectSysRediagBydiagId(Long diagId);
}
