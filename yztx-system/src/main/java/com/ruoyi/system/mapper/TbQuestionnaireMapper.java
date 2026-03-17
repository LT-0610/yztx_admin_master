package com.ruoyi.system.mapper;


import com.ruoyi.system.domain.TbQuestionnaire;

import java.util.List;

/**
 * 问卷调查管理Mapper接口
 * 
 * @author astar
 * @date 2024-03-01
 */
public interface TbQuestionnaireMapper 
{
    /**
     * 查询问卷调查管理
     * 
     * @param id 问卷调查管理主键
     * @return 问卷调查管理
     */
    public TbQuestionnaire selectTbQuestionnaireById(Long id);

    /**
     * 查询问卷调查管理列表
     * 
     * @param tbQuestionnaire 问卷调查管理
     * @return 问卷调查管理集合
     */
    public List<TbQuestionnaire> selectTbQuestionnaireList(TbQuestionnaire tbQuestionnaire);

    /**
     * 新增问卷调查管理
     * 
     * @param tbQuestionnaire 问卷调查管理
     * @return 结果
     */
    public int insertTbQuestionnaire(TbQuestionnaire tbQuestionnaire);

    /**
     * 修改问卷调查管理
     * 
     * @param tbQuestionnaire 问卷调查管理
     * @return 结果
     */
    public int updateTbQuestionnaire(TbQuestionnaire tbQuestionnaire);

    /**
     * 删除问卷调查管理
     * 
     * @param id 问卷调查管理主键
     * @return 结果
     */
    public int deleteTbQuestionnaireById(Long id);

    /**
     * 批量删除问卷调查管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbQuestionnaireByIds(Long[] ids);

    /**
     * 获取问卷配置
     * @param url
     * @return {@link TbQuestionnaire}
     */
    TbQuestionnaire getQs(String url);
}
