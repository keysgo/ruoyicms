package com.ruoyi.keystospider.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.keystospider.mapper.KeystoPngimgMapper;
import com.ruoyi.keystospider.domain.KeystoPngimg;
import com.ruoyi.keystospider.service.IKeystoPngimgService;
import com.ruoyi.common.core.text.Convert;

/**
 * png图片Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-27
 */
@Service
public class KeystoPngimgServiceImpl implements IKeystoPngimgService 
{
    @Autowired
    private KeystoPngimgMapper keystoPngimgMapper;

    /**
     * 查询png图片
     * 
     * @param id png图片主键
     * @return png图片
     */
    @Override
    public KeystoPngimg selectKeystoPngimgById(Long id)
    {
        return keystoPngimgMapper.selectKeystoPngimgById(id);
    }

    /**
     * 查询png图片列表
     * 
     * @param keystoPngimg png图片
     * @return png图片
     */
    @Override
    public List<KeystoPngimg> selectKeystoPngimgList(KeystoPngimg keystoPngimg)
    {
        return keystoPngimgMapper.selectKeystoPngimgList(keystoPngimg);
    }

    /**
     * 新增png图片
     * 
     * @param keystoPngimg png图片
     * @return 结果
     */
    @Override
    public int insertKeystoPngimg(KeystoPngimg keystoPngimg)
    {
        return keystoPngimgMapper.insertKeystoPngimg(keystoPngimg);
    }

    /**
     * 修改png图片
     * 
     * @param keystoPngimg png图片
     * @return 结果
     */
    @Override
    public int updateKeystoPngimg(KeystoPngimg keystoPngimg)
    {
        return keystoPngimgMapper.updateKeystoPngimg(keystoPngimg);
    }

    /**
     * 批量删除png图片
     * 
     * @param ids 需要删除的png图片主键
     * @return 结果
     */
    @Override
    public int deleteKeystoPngimgByIds(String ids)
    {
        return keystoPngimgMapper.deleteKeystoPngimgByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除png图片信息
     * 
     * @param id png图片主键
     * @return 结果
     */
    @Override
    public int deleteKeystoPngimgById(Long id)
    {
        return keystoPngimgMapper.deleteKeystoPngimgById(id);
    }
}
