package com.ruoyi.keystospider.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.keystospider.mapper.KeystoProductMapper;
import com.ruoyi.keystospider.domain.KeystoProduct;
import com.ruoyi.keystospider.service.IKeystoProductService;
import com.ruoyi.common.core.text.Convert;

/**
 * 亚马逊产品Service业务层处理
 * 
 * @author keysto
 * @date 2022-11-16
 */
@Service
public class KeystoProductServiceImpl implements IKeystoProductService 
{
    @Autowired
    private KeystoProductMapper keystoProductMapper;

    /**
     * 查询亚马逊产品
     * 
     * @param id 亚马逊产品主键
     * @return 亚马逊产品
     */
    @Override
    public KeystoProduct selectKeystoProductById(Long id)
    {
        return keystoProductMapper.selectKeystoProductById(id);
    }

    /**
     * 查询亚马逊产品列表
     * 
     * @param keystoProduct 亚马逊产品
     * @return 亚马逊产品
     */
    @Override
    public List<KeystoProduct> selectKeystoProductList(KeystoProduct keystoProduct)
    {
        return keystoProductMapper.selectKeystoProductList(keystoProduct);
    }

    /**
     * 新增亚马逊产品
     * 
     * @param keystoProduct 亚马逊产品
     * @return 结果
     */
    @Override
    public int insertKeystoProduct(KeystoProduct keystoProduct)
    {
        keystoProduct.setCreateTime(DateUtils.getNowDate());
        return keystoProductMapper.insertKeystoProduct(keystoProduct);
    }

    /**
     * 修改亚马逊产品
     * 
     * @param keystoProduct 亚马逊产品
     * @return 结果
     */
    @Override
    public int updateKeystoProduct(KeystoProduct keystoProduct)
    {
        keystoProduct.setUpdateTime(DateUtils.getNowDate());
        return keystoProductMapper.updateKeystoProduct(keystoProduct);
    }

    /**
     * 批量删除亚马逊产品
     * 
     * @param ids 需要删除的亚马逊产品主键
     * @return 结果
     */
    @Override
    public int deleteKeystoProductByIds(String ids)
    {
        return keystoProductMapper.deleteKeystoProductByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除亚马逊产品信息
     * 
     * @param id 亚马逊产品主键
     * @return 结果
     */
    @Override
    public int deleteKeystoProductById(Long id)
    {
        return keystoProductMapper.deleteKeystoProductById(id);
    }
}
