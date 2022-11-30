package com.ruoyi.home.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.home.mapper.KeystoPngimgMapper;
import com.ruoyi.home.domain.KeystoPngimg;
import com.ruoyi.home.service.IKeystoPngimgService;
import com.ruoyi.common.core.text.Convert;

/**
 * png前端Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-30
 */
@Service
public class KeystoPngimgServiceImpl implements IKeystoPngimgService 
{
    @Autowired
    private KeystoPngimgMapper keystoPngimgMapper;

    /**
     * 查询png前端
     * 
     * @param id png前端主键
     * @return png前端
     */
    @Override
    public KeystoPngimg selectKeystoPngimgById(Long id)
    {
        return keystoPngimgMapper.selectKeystoPngimgById(id);
    }

    /**
     * 查询png前端列表
     * 
     * @param keystoPngimg png前端
     * @return png前端
     */
    @Override
    public List<KeystoPngimg> selectKeystoPngimgList(KeystoPngimg keystoPngimg)
    {
        return keystoPngimgMapper.selectKeystoPngimgList(keystoPngimg);
    }

    /**
     * 新增png前端
     * 
     * @param keystoPngimg png前端
     * @return 结果
     */
    @Override
    public int insertKeystoPngimg(KeystoPngimg keystoPngimg)
    {
        return keystoPngimgMapper.insertKeystoPngimg(keystoPngimg);
    }

    /**
     * 修改png前端
     * 
     * @param keystoPngimg png前端
     * @return 结果
     */
    @Override
    public int updateKeystoPngimg(KeystoPngimg keystoPngimg)
    {
        return keystoPngimgMapper.updateKeystoPngimg(keystoPngimg);
    }

    /**
     * 批量删除png前端
     * 
     * @param ids 需要删除的png前端主键
     * @return 结果
     */
    @Override
    public int deleteKeystoPngimgByIds(String ids)
    {
        return keystoPngimgMapper.deleteKeystoPngimgByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除png前端信息
     * 
     * @param id png前端主键
     * @return 结果
     */
    @Override
    public int deleteKeystoPngimgById(Long id)
    {
        return keystoPngimgMapper.deleteKeystoPngimgById(id);
    }
}
