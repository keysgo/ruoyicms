package com.ruoyi.keystospider.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.keystospider.mapper.KeystoPngimgMapper;
import com.ruoyi.keystospider.domain.KeystoPngimg;
import com.ruoyi.keystospider.service.IKeystoPngimgService;
import com.ruoyi.common.core.text.Convert;

/**
 * png管理Service业务层处理
 * 
 * @author keysto
 * @date 2022-11-27
 */
@Service
public class KeystoPngimgServiceImpl implements IKeystoPngimgService 
{
    @Autowired
    private KeystoPngimgMapper keystoPngimgMapper;

    /**
     * 查询png管理
     * 
     * @param id png管理主键
     * @return png管理
     */
    @Override
    public KeystoPngimg selectKeystoPngimgById(Long id)
    {
        return keystoPngimgMapper.selectKeystoPngimgById(id);
    }

    /**
     * 查询png管理列表
     * 
     * @param keystoPngimg png管理
     * @return png管理
     */
    @Override
    public List<KeystoPngimg> selectKeystoPngimgList(KeystoPngimg keystoPngimg)
    {
        return keystoPngimgMapper.selectKeystoPngimgList(keystoPngimg);
    }

    /**
     * 新增png管理
     * 
     * @param keystoPngimg png管理
     * @return 结果
     */
    @Override
    public int insertKeystoPngimg(KeystoPngimg keystoPngimg)
    {
        return keystoPngimgMapper.insertKeystoPngimg(keystoPngimg);
    }

    /**
     * 修改png管理
     * 
     * @param keystoPngimg png管理
     * @return 结果
     */
    @Override
    public int updateKeystoPngimg(KeystoPngimg keystoPngimg)
    {
        return keystoPngimgMapper.updateKeystoPngimg(keystoPngimg);
    }

    /**
     * 批量删除png管理
     * 
     * @param ids 需要删除的png管理主键
     * @return 结果
     */
    @Override
    public int deleteKeystoPngimgByIds(String ids)
    {
        return keystoPngimgMapper.deleteKeystoPngimgByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除png管理信息
     * 
     * @param id png管理主键
     * @return 结果
     */
    @Override
    public int deleteKeystoPngimgById(Long id)
    {
        return keystoPngimgMapper.deleteKeystoPngimgById(id);
    }
}
