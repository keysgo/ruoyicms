package com.ruoyi.test.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.test.mapper.TestXixinMapper;
import com.ruoyi.test.domain.TestXixin;
import com.ruoyi.test.service.ITestXixinService;
import com.ruoyi.common.core.text.Convert;

/**
 * 个人信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-09
 */
@Service
public class TestXixinServiceImpl implements ITestXixinService 
{
    @Autowired
    private TestXixinMapper testXixinMapper;

    /**
     * 查询个人信息
     * 
     * @param id 个人信息主键
     * @return 个人信息
     */
    @Override
    public TestXixin selectTestXixinById(Long id)
    {
        return testXixinMapper.selectTestXixinById(id);
    }

    /**
     * 查询个人信息列表
     * 
     * @param testXixin 个人信息
     * @return 个人信息
     */
    @Override
    public List<TestXixin> selectTestXixinList(TestXixin testXixin)
    {
        return testXixinMapper.selectTestXixinList(testXixin);
    }

    /**
     * 新增个人信息
     * 
     * @param testXixin 个人信息
     * @return 结果
     */
    @Override
    public int insertTestXixin(TestXixin testXixin)
    {
        return testXixinMapper.insertTestXixin(testXixin);
    }

    /**
     * 修改个人信息
     * 
     * @param testXixin 个人信息
     * @return 结果
     */
    @Override
    public int updateTestXixin(TestXixin testXixin)
    {
        return testXixinMapper.updateTestXixin(testXixin);
    }

    /**
     * 批量删除个人信息
     * 
     * @param ids 需要删除的个人信息主键
     * @return 结果
     */
    @Override
    public int deleteTestXixinByIds(String ids)
    {
        return testXixinMapper.deleteTestXixinByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除个人信息信息
     * 
     * @param id 个人信息主键
     * @return 结果
     */
    @Override
    public int deleteTestXixinById(Long id)
    {
        return testXixinMapper.deleteTestXixinById(id);
    }
}
