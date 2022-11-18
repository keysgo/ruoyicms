package com.ruoyi.keystospider.service;

import java.util.List;
import com.ruoyi.keystospider.domain.KeystoSpiderFiledRule;

/**
 * 字段规则Service接口
 * 
 * @author keysto
 * @date 2022-11-09
 */
public interface IKeystoSpiderFiledRuleService 
{
    /**
     * 查询字段规则
     * 
     * @param id 字段规则主键
     * @return 字段规则
     */
    public KeystoSpiderFiledRule selectKeystoSpiderFiledRuleById(Long id);

    /**
     * 查询字段规则列表
     * 
     * @param keystoSpiderFiledRule 字段规则
     * @return 字段规则集合
     */
    public List<KeystoSpiderFiledRule> selectKeystoSpiderFiledRuleList(KeystoSpiderFiledRule keystoSpiderFiledRule);

    /**
     * 新增字段规则
     * 
     * @param keystoSpiderFiledRule 字段规则
     * @return 结果
     */
    public int insertKeystoSpiderFiledRule(KeystoSpiderFiledRule keystoSpiderFiledRule);

    /**
     * 修改字段规则
     * 
     * @param keystoSpiderFiledRule 字段规则
     * @return 结果
     */
    public int updateKeystoSpiderFiledRule(KeystoSpiderFiledRule keystoSpiderFiledRule);

    /**
     * 批量删除字段规则
     * 
     * @param ids 需要删除的字段规则主键集合
     * @return 结果
     */
    public int deleteKeystoSpiderFiledRuleByIds(String ids);

    /**
     * 删除字段规则信息
     * 
     * @param id 字段规则主键
     * @return 结果
     */
    public int deleteKeystoSpiderFiledRuleById(Long id);
}
