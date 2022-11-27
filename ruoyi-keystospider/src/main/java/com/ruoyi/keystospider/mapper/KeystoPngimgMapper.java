package com.ruoyi.keystospider.mapper;

import java.util.List;
import com.ruoyi.keystospider.domain.KeystoPngimg;

/**
 * png图片Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-27
 */
public interface KeystoPngimgMapper 
{
    /**
     * 查询png图片
     * 
     * @param id png图片主键
     * @return png图片
     */
    public KeystoPngimg selectKeystoPngimgById(Long id);

    /**
     * 查询png图片列表
     * 
     * @param keystoPngimg png图片
     * @return png图片集合
     */
    public List<KeystoPngimg> selectKeystoPngimgList(KeystoPngimg keystoPngimg);

    /**
     * 新增png图片
     * 
     * @param keystoPngimg png图片
     * @return 结果
     */
    public int insertKeystoPngimg(KeystoPngimg keystoPngimg);

    /**
     * 修改png图片
     * 
     * @param keystoPngimg png图片
     * @return 结果
     */
    public int updateKeystoPngimg(KeystoPngimg keystoPngimg);

    /**
     * 删除png图片
     * 
     * @param id png图片主键
     * @return 结果
     */
    public int deleteKeystoPngimgById(Long id);

    /**
     * 批量删除png图片
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteKeystoPngimgByIds(String[] ids);
}
