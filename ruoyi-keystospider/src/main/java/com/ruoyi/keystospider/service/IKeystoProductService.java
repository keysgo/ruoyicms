package com.ruoyi.keystospider.service;

import java.util.List;
import com.ruoyi.keystospider.domain.KeystoProduct;

/**
 * 亚马逊产品Service接口
 * 
 * @author keysto
 * @date 2022-11-16
 */
public interface IKeystoProductService 
{
    /**
     * 查询亚马逊产品
     * 
     * @param id 亚马逊产品主键
     * @return 亚马逊产品
     */
    public KeystoProduct selectKeystoProductById(Long id);

    /**
     * 查询亚马逊产品列表
     * 
     * @param keystoProduct 亚马逊产品
     * @return 亚马逊产品集合
     */
    public List<KeystoProduct> selectKeystoProductList(KeystoProduct keystoProduct);

    /**
     * 新增亚马逊产品
     * 
     * @param keystoProduct 亚马逊产品
     * @return 结果
     */
    public int insertKeystoProduct(KeystoProduct keystoProduct);

    /**
     * 修改亚马逊产品
     * 
     * @param keystoProduct 亚马逊产品
     * @return 结果
     */
    public int updateKeystoProduct(KeystoProduct keystoProduct);

    /**
     * 批量删除亚马逊产品
     * 
     * @param ids 需要删除的亚马逊产品主键集合
     * @return 结果
     */
    public int deleteKeystoProductByIds(String ids);

    /**
     * 删除亚马逊产品信息
     * 
     * @param id 亚马逊产品主键
     * @return 结果
     */
    public int deleteKeystoProductById(Long id);
}
