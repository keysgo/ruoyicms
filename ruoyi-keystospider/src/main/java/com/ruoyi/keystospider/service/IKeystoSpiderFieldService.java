package com.ruoyi.keystospider.service;

import java.util.List;
import com.ruoyi.keystospider.domain.KeystoSpiderField;

/**
 * 爬虫管理Service接口
 * 
 * @author keysto
 * @date 2022-11-09
 */
public interface IKeystoSpiderFieldService 
{
    /**
     * 查询爬虫管理
     * 
     * @param fieldId 爬虫管理主键
     * @return 爬虫管理
     */
    public KeystoSpiderField selectKeystoSpiderFieldByFieldId(Long fieldId);

    /**
     * 查询爬虫管理列表
     * 
     * @param keystoSpiderField 爬虫管理
     * @return 爬虫管理集合
     */
    public List<KeystoSpiderField> selectKeystoSpiderFieldList(KeystoSpiderField keystoSpiderField);

    /**
     * 新增爬虫管理
     * 
     * @param keystoSpiderField 爬虫管理
     * @return 结果
     */
    public int insertKeystoSpiderField(KeystoSpiderField keystoSpiderField);

    /**
     * 修改爬虫管理
     * 
     * @param keystoSpiderField 爬虫管理
     * @return 结果
     */
    public int updateKeystoSpiderField(KeystoSpiderField keystoSpiderField);

    /**
     * 批量删除爬虫管理
     * 
     * @param fieldIds 需要删除的爬虫管理主键集合
     * @return 结果
     */
    public int deleteKeystoSpiderFieldByFieldIds(String fieldIds);

    /**
     * 删除爬虫管理信息
     * 
     * @param fieldId 爬虫管理主键
     * @return 结果
     */
    public int deleteKeystoSpiderFieldByFieldId(Long fieldId);
}
