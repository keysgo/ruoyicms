package com.ruoyi.home.service.impl;

import java.util.List;

import com.ruoyi.home.domain.KeystoPngingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.home.mapper.KeystoPngimgHomeMapper;
import com.ruoyi.home.domain.KeystoPngimgHome;
import com.ruoyi.home.service.IKeystoPngimgHomeService;
import com.ruoyi.common.core.text.Convert;

/**
 * png前端Service业务层处理
 * 
 * @author keysto
 * @date 2022-11-30
 */
@Service
public class KeystoPngimgHomeServiceImpl implements IKeystoPngimgHomeService 
{
    @Autowired
    private KeystoPngimgHomeMapper keystoPngimgHomeMapper;



    /**
     * 查询png前端
     * 
     * @param id png前端主键
     * @return png前端
     */
    @Override
    public KeystoPngimgHome selectKeystoPngimgHomeById(Long id)
    {
        return keystoPngimgHomeMapper.selectKeystoPngimgHomeById(id);
    }

    /**
     * 查询png前端列表
     * 
     * @param keystoPngimgHome png前端
     * @return png前端
     */
    @Override
    public List<KeystoPngimgHome> selectKeystoPngimgHomeList(KeystoPngimgHome keystoPngimgHome)
    {
        return keystoPngimgHomeMapper.selectKeystoPngimgHomeList(keystoPngimgHome);
    }

    /**
     * 新增png前端
     * 
     * @param keystoPngimgHome png前端
     * @return 结果
     */
    @Override
    public int insertKeystoPngimgHome(KeystoPngimgHome keystoPngimgHome)
    {
        return keystoPngimgHomeMapper.insertKeystoPngimgHome(keystoPngimgHome);
    }

    /**
     * 修改png前端
     * 
     * @param keystoPngimgHome png前端
     * @return 结果
     */
    @Override
    public int updateKeystoPngimgHome(KeystoPngimgHome keystoPngimgHome)
    {
        return keystoPngimgHomeMapper.updateKeystoPngimgHome(keystoPngimgHome);
    }

    /**
     * 批量删除png前端
     * 
     * @param ids 需要删除的png前端主键
     * @return 结果
     */
    @Override
    public int deleteKeystoPngimgHomeByIds(String ids)
    {
        return keystoPngimgHomeMapper.deleteKeystoPngimgHomeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除png前端信息
     * 
     * @param id png前端主键
     * @return 结果
     */
    @Override
    public int deleteKeystoPngimgHomeById(Long id)
    {
        return keystoPngimgHomeMapper.deleteKeystoPngimgHomeById(id);
    }

    /***
     * 查询分类，返回分类数量名称和id
     * @return
     */
    @Override
    public List<KeystoPngingType> selectKeystoPngimgTypeList() {
        return keystoPngimgHomeMapper.selectKeystoPngimgTypeList();
    }
}
