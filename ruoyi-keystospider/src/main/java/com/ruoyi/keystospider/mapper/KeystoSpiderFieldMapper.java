package com.ruoyi.keystospider.mapper;

import java.util.List;
import com.ruoyi.keystospider.domain.KeystoSpiderField;

/**
 * 爬虫管理Mapper接口
 * 
 * @author keysto
 * @date 2022-11-09
 */
public interface KeystoSpiderFieldMapper 
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
     * 删除爬虫管理
     * 
     * @param fieldId 爬虫管理主键
     * @return 结果
     */
    public int deleteKeystoSpiderFieldByFieldId(Long fieldId);

    /**
     * 批量删除爬虫管理
     * 
     * @param fieldIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteKeystoSpiderFieldByFieldIds(String[] fieldIds);
}
