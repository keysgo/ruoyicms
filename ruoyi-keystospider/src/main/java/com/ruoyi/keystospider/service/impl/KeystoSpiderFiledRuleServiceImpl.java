package com.ruoyi.keystospider.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.keystospider.mapper.KeystoSpiderFiledRuleMapper;
import com.ruoyi.keystospider.domain.KeystoSpiderFiledRule;
import com.ruoyi.keystospider.service.IKeystoSpiderFiledRuleService;
import com.ruoyi.common.core.text.Convert;

/**
 * 字段规则Service业务层处理
 * 
 * @author keysto
 * @date 2022-11-09
 */
@Service
public class KeystoSpiderFiledRuleServiceImpl implements IKeystoSpiderFiledRuleService 
{
    @Autowired
    private KeystoSpiderFiledRuleMapper keystoSpiderFiledRuleMapper;

    /**
     * 查询字段规则
     * 
     * @param id 字段规则主键
     * @return 字段规则
     */
    @Override
    public KeystoSpiderFiledRule selectKeystoSpiderFiledRuleById(Long id)
    {
        return keystoSpiderFiledRuleMapper.selectKeystoSpiderFiledRuleById(id);
    }

    /**
     * 查询字段规则列表
     * 
     * @param keystoSpiderFiledRule 字段规则
     * @return 字段规则
     */
    @Override
    public List<KeystoSpiderFiledRule> selectKeystoSpiderFiledRuleList(KeystoSpiderFiledRule keystoSpiderFiledRule)
    {
        return keystoSpiderFiledRuleMapper.selectKeystoSpiderFiledRuleList(keystoSpiderFiledRule);
    }

    /**
     * 新增字段规则
     * 
     * @param keystoSpiderFiledRule 字段规则
     * @return 结果
     */
    @Override
    public int insertKeystoSpiderFiledRule(KeystoSpiderFiledRule keystoSpiderFiledRule)
    {
        return keystoSpiderFiledRuleMapper.insertKeystoSpiderFiledRule(keystoSpiderFiledRule);
    }

    /**
     * 修改字段规则
     * 
     * @param keystoSpiderFiledRule 字段规则
     * @return 结果
     */
    @Override
    public int updateKeystoSpiderFiledRule(KeystoSpiderFiledRule keystoSpiderFiledRule)
    {
        return keystoSpiderFiledRuleMapper.updateKeystoSpiderFiledRule(keystoSpiderFiledRule);
    }

    /**
     * 批量删除字段规则
     * 
     * @param ids 需要删除的字段规则主键
     * @return 结果
     */
    @Override
    public int deleteKeystoSpiderFiledRuleByIds(String ids)
    {
        return keystoSpiderFiledRuleMapper.deleteKeystoSpiderFiledRuleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除字段规则信息
     * 
     * @param id 字段规则主键
     * @return 结果
     */
    @Override
    public int deleteKeystoSpiderFiledRuleById(Long id)
    {
        return keystoSpiderFiledRuleMapper.deleteKeystoSpiderFiledRuleById(id);
    }
}
