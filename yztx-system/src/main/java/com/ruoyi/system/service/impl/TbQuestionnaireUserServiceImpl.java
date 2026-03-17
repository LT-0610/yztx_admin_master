package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.TbQuestionnaireUser;
import com.ruoyi.system.mapper.TbQuestionnaireUserMapper;
import com.ruoyi.system.service.ITbQuestionnaireUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 填写问卷管理Service业务层处理
 * 
 * @author astar
 * @date 2024-03-01
 */
@Service
public class TbQuestionnaireUserServiceImpl implements ITbQuestionnaireUserService
{
    @Autowired
    private TbQuestionnaireUserMapper tbQuestionnaireUserMapper;

    /**
     * 查询填写问卷管理
     * 
     * @param id 填写问卷管理主键
     * @return 填写问卷管理
     */
    @Override
    public TbQuestionnaireUser selectTbQuestionnaireUserById(Long id)
    {
        return tbQuestionnaireUserMapper.selectTbQuestionnaireUserById(id);
    }

    /**
     * 查询填写问卷管理列表
     * 
     * @param tbQuestionnaireUser 填写问卷管理
     * @return 填写问卷管理
     */
    @Override
    public List<TbQuestionnaireUser> selectTbQuestionnaireUserList(TbQuestionnaireUser tbQuestionnaireUser)
    {
        return tbQuestionnaireUserMapper.selectTbQuestionnaireUserList(tbQuestionnaireUser);
    }

    /**
     * 新增填写问卷管理
     * 
     * @param tbQuestionnaireUser 填写问卷管理
     * @return 结果
     */
    @Override
    public int insertTbQuestionnaireUser(TbQuestionnaireUser tbQuestionnaireUser)
    {
        return tbQuestionnaireUserMapper.insertTbQuestionnaireUser(tbQuestionnaireUser);
    }

    /**
     * 修改填写问卷管理
     * 
     * @param tbQuestionnaireUser 填写问卷管理
     * @return 结果
     */
    @Override
    public int updateTbQuestionnaireUser(TbQuestionnaireUser tbQuestionnaireUser)
    {
        return tbQuestionnaireUserMapper.updateTbQuestionnaireUser(tbQuestionnaireUser);
    }

    /**
     * 批量删除填写问卷管理
     * 
     * @param ids 需要删除的填写问卷管理主键
     * @return 结果
     */
    @Override
    public int deleteTbQuestionnaireUserByIds(Long[] ids)
    {
        return tbQuestionnaireUserMapper.deleteTbQuestionnaireUserByIds(ids);
    }

    /**
     * 删除填写问卷管理信息
     * 
     * @param id 填写问卷管理主键
     * @return 结果
     */
    @Override
    public int deleteTbQuestionnaireUserById(Long id)
    {
        return tbQuestionnaireUserMapper.deleteTbQuestionnaireUserById(id);
    }
}
