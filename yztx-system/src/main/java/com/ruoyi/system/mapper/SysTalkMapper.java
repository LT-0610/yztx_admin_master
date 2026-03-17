package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysTalk;

/**
 * 话题信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-07
 */
public interface SysTalkMapper 
{
    /**
     * 查询话题信息
     * 
     * @param id 话题信息主键
     * @return 话题信息
     */
    public SysTalk selectSysTalkById(Long id);

    /**
     * 查询话题信息列表
     * 
     * @param sysTalk 话题信息
     * @return 话题信息集合
     */
    public List<SysTalk> selectSysTalkList(SysTalk sysTalk);

    /**
     * 新增话题信息
     * 
     * @param sysTalk 话题信息
     * @return 结果
     */
    public int insertSysTalk(SysTalk sysTalk);

    /**
     * 修改话题信息
     * 
     * @param sysTalk 话题信息
     * @return 结果
     */
    public int updateSysTalk(SysTalk sysTalk);

    /**
     * 删除话题信息
     * 
     * @param id 话题信息主键
     * @return 结果
     */
    public int deleteSysTalkById(Long id);

    /**
     * 批量删除话题信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysTalkByIds(Long[] ids);
}
