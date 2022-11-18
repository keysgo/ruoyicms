package com.ruoyi.keystospider.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.keystospider.mapper.KeystoSpiderFieldMapper;
import com.ruoyi.keystospider.domain.KeystoSpiderField;
import com.ruoyi.keystospider.service.IKeystoSpiderFieldService;
import com.ruoyi.common.core.text.Convert;

/**
 * 爬虫管理Service业务层处理
 * 
 * @author keysto
 * @date 2022-11-09
 */
@Service
public class KeystoSpiderFieldServiceImpl implements IKeystoSpiderFieldService 
{
    @Autowired
    private KeystoSpiderFieldMapper keystoSpiderFieldMapper;

    /**
     * 查询爬虫管理
     * 
     * @param fieldId 爬虫管理主键
     * @return 爬虫管理
     */
    @Override
    public KeystoSpiderField selectKeystoSpiderFieldByFieldId(Long fieldId)
    {
        return keystoSpiderFieldMapper.selectKeystoSpiderFieldByFieldId(fieldId);
    }

    /**
     * 查询爬虫管理列表
     * 
     * @param keystoSpiderField 爬虫管理
     * @return 爬虫管理
     */
    @Override
    public List<KeystoSpiderField> selectKeystoSpiderFieldList(KeystoSpiderField keystoSpiderField)
    {
        return keystoSpiderFieldMapper.selectKeystoSpiderFieldList(keystoSpiderField);
    }

    /**
     * 新增爬虫管理
     * 
     * @param keystoSpiderField 爬虫管理
     * @return 结果
     */
    @Override
    public int insertKeystoSpiderField(KeystoSpiderField keystoSpiderField)
    {
        return keystoSpiderFieldMapper.insertKeystoSpiderField(keystoSpiderField);
    }

    /**
     * 修改爬虫管理
     * 
     * @param keystoSpiderField 爬虫管理
     * @return 结果
     */
    @Override
    public int updateKeystoSpiderField(KeystoSpiderField keystoSpiderField)
    {
        return keystoSpiderFieldMapper.updateKeystoSpiderField(keystoSpiderField);
    }

    /**
     * 批量删除爬虫管理
     * 
     * @param fieldIds 需要删除的爬虫管理主键
     * @return 结果
     */
    @Override
    public int deleteKeystoSpiderFieldByFieldIds(String fieldIds)
    {
        return keystoSpiderFieldMapper.deleteKeystoSpiderFieldByFieldIds(Convert.toStrArray(fieldIds));
    }

    /**
     * 删除爬虫管理信息
     * 
     * @param fieldId 爬虫管理主键
     * @return 结果
     */
    @Override
    public int deleteKeystoSpiderFieldByFieldId(Long fieldId)
    {
        return keystoSpiderFieldMapper.deleteKeystoSpiderFieldByFieldId(fieldId);
    }
}
