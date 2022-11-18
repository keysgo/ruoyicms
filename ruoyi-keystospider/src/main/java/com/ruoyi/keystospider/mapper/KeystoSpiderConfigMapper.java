package com.ruoyi.keystospider.mapper;

import java.util.List;
import com.ruoyi.keystospider.domain.KeystoSpiderConfig;

/**
 * 爬虫管理Mapper接口
 * 
 * @author keysto
 * @date 2022-11-09
 */
public interface KeystoSpiderConfigMapper 
{
    /**
     * 查询爬虫管理
     * 
     * @param id 爬虫管理主键
     * @return 爬虫管理
     */
    public KeystoSpiderConfig selectKeystoSpiderConfigById(Long id);

    /**
     * 查询爬虫管理列表
     * 
     * @param keystoSpiderConfig 爬虫管理
     * @return 爬虫管理集合
     */
    public List<KeystoSpiderConfig> selectKeystoSpiderConfigList(KeystoSpiderConfig keystoSpiderConfig);

    /**
     * 新增爬虫管理
     * 
     * @param keystoSpiderConfig 爬虫管理
     * @return 结果
     */
    public int insertKeystoSpiderConfig(KeystoSpiderConfig keystoSpiderConfig);

    /**
     * 修改爬虫管理
     * 
     * @param keystoSpiderConfig 爬虫管理
     * @return 结果
     */
    public int updateKeystoSpiderConfig(KeystoSpiderConfig keystoSpiderConfig);

    /**
     * 删除爬虫管理
     * 
     * @param id 爬虫管理主键
     * @return 结果
     */
    public int deleteKeystoSpiderConfigById(Long id);

    /**
     * 批量删除爬虫管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteKeystoSpiderConfigByIds(String[] ids);
}
