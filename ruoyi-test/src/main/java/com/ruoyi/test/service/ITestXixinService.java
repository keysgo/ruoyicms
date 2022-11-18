package com.ruoyi.test.service;

import java.util.List;
import com.ruoyi.test.domain.TestXixin;

/**
 * 个人信息Service接口
 * 
 * @author ruoyi
 * @date 2022-11-09
 */
public interface ITestXixinService 
{
    /**
     * 查询个人信息
     * 
     * @param id 个人信息主键
     * @return 个人信息
     */
    public TestXixin selectTestXixinById(Long id);

    /**
     * 查询个人信息列表
     * 
     * @param testXixin 个人信息
     * @return 个人信息集合
     */
    public List<TestXixin> selectTestXixinList(TestXixin testXixin);

    /**
     * 新增个人信息
     * 
     * @param testXixin 个人信息
     * @return 结果
     */
    public int insertTestXixin(TestXixin testXixin);

    /**
     * 修改个人信息
     * 
     * @param testXixin 个人信息
     * @return 结果
     */
    public int updateTestXixin(TestXixin testXixin);

    /**
     * 批量删除个人信息
     * 
     * @param ids 需要删除的个人信息主键集合
     * @return 结果
     */
    public int deleteTestXixinByIds(String ids);

    /**
     * 删除个人信息信息
     * 
     * @param id 个人信息主键
     * @return 结果
     */
    public int deleteTestXixinById(Long id);
}
