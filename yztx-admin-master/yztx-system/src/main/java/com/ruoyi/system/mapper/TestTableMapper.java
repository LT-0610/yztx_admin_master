package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TestTable;

/**
 * 大数据结果数据集Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-20
 */
public interface TestTableMapper 
{
    /**
     * 查询大数据结果数据集
     * 
     * @param id 大数据结果数据集主键
     * @return 大数据结果数据集
     */
    public TestTable selectTestTableById(Long id);

    /**
     * 查询大数据结果数据集列表
     * @return 大数据结果数据集集合
     */
    public List<TestTable> selectTestTableList();

    /**
     * 新增大数据结果数据集
     * 
     * @param testTable 大数据结果数据集
     * @return 结果
     */
    public int insertTestTable(TestTable testTable);

    /**
     * 修改大数据结果数据集
     * 
     * @param testTable 大数据结果数据集
     * @return 结果
     */
    public int updateTestTable(TestTable testTable);

    /**
     * 删除大数据结果数据集
     * 
     * @param id 大数据结果数据集主键
     * @return 结果
     */
    public int deleteTestTableById(Long id);

    /**
     * 批量删除大数据结果数据集
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTestTableByIds(Long[] ids);
}
