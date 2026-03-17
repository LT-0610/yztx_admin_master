package com.ruoyi.system.service;

import com.ruoyi.system.domain.TbQuestionnaireUser;

import java.util.List;

/**
 * 填写问卷管理Service接口
 * 
 * @author astar
 * @date 2024-03-01
 */
public interface ITbQuestionnaireUserService 
{
    /**
     * 查询填写问卷管理
     * 
     * @param id 填写问卷管理主键
     * @return 填写问卷管理
     */
    public TbQuestionnaireUser selectTbQuestionnaireUserById(Long id);

    /**
     * 查询填写问卷管理列表
     * 
     * @param tbQuestionnaireUser 填写问卷管理
     * @return 填写问卷管理集合
     */
    public List<TbQuestionnaireUser> selectTbQuestionnaireUserList(TbQuestionnaireUser tbQuestionnaireUser);

    /**
     * 新增填写问卷管理
     * 
     * @param tbQuestionnaireUser 填写问卷管理
     * @return 结果
     */
    public int insertTbQuestionnaireUser(TbQuestionnaireUser tbQuestionnaireUser);

    /**
     * 修改填写问卷管理
     * 
     * @param tbQuestionnaireUser 填写问卷管理
     * @return 结果
     */
    public int updateTbQuestionnaireUser(TbQuestionnaireUser tbQuestionnaireUser);

    /**
     * 批量删除填写问卷管理
     * 
     * @param ids 需要删除的填写问卷管理主键集合
     * @return 结果
     */
    public int deleteTbQuestionnaireUserByIds(Long[] ids);

    /**
     * 删除填写问卷管理信息
     * 
     * @param id 填写问卷管理主键
     * @return 结果
     */
    public int deleteTbQuestionnaireUserById(Long id);
}
