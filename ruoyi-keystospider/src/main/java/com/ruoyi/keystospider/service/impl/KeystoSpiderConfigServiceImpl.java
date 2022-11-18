package com.ruoyi.keystospider.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.keystospider.mapper.KeystoSpiderConfigMapper;
import com.ruoyi.keystospider.domain.KeystoSpiderConfig;
import com.ruoyi.keystospider.service.IKeystoSpiderConfigService;
import com.ruoyi.common.core.text.Convert;

/**
 * 爬虫管理Service业务层处理
 * 
 * @author keysto
 * @date 2022-11-09
 */
@Service
public class KeystoSpiderConfigServiceImpl implements IKeystoSpiderConfigService 
{
    @Autowired
    private KeystoSpiderConfigMapper keystoSpiderConfigMapper;

    /**
     * 查询爬虫管理
     * 
     * @param id 爬虫管理主键
     * @return 爬虫管理
     */
    @Override
    public KeystoSpiderConfig selectKeystoSpiderConfigById(Long id)
    {
        return keystoSpiderConfigMapper.selectKeystoSpiderConfigById(id);
    }

    /**
     * 查询爬虫管理列表
     * 
     * @param keystoSpiderConfig 爬虫管理
     * @return 爬虫管理
     */
    @Override
    public List<KeystoSpiderConfig> selectKeystoSpiderConfigList(KeystoSpiderConfig keystoSpiderConfig)
    {
        return keystoSpiderConfigMapper.selectKeystoSpiderConfigList(keystoSpiderConfig);
    }

    /**
     * 新增爬虫管理
     * 
     * @param keystoSpiderConfig 爬虫管理
     * @return 结果
     */
    @Override
    public int insertKeystoSpiderConfig(KeystoSpiderConfig keystoSpiderConfig)
    {
        return keystoSpiderConfigMapper.insertKeystoSpiderConfig(keystoSpiderConfig);
    }

    /**
     * 修改爬虫管理
     * 
     * @param keystoSpiderConfig 爬虫管理
     * @return 结果
     */
    @Override
    public int updateKeystoSpiderConfig(KeystoSpiderConfig keystoSpiderConfig)
    {
        return keystoSpiderConfigMapper.updateKeystoSpiderConfig(keystoSpiderConfig);
    }

    /**
     * 批量删除爬虫管理
     * 
     * @param ids 需要删除的爬虫管理主键
     * @return 结果
     */
    @Override
    public int deleteKeystoSpiderConfigByIds(String ids)
    {
        return keystoSpiderConfigMapper.deleteKeystoSpiderConfigByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除爬虫管理信息
     * 
     * @param id 爬虫管理主键
     * @return 结果
     */
    @Override
    public int deleteKeystoSpiderConfigById(Long id)
    {
        return keystoSpiderConfigMapper.deleteKeystoSpiderConfigById(id);
    }
}
