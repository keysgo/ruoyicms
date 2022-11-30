package com.ruoyi.home.mapper;

import java.util.List;
import com.ruoyi.home.domain.KeystoPngimg;

/**
 * png前端Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-30
 */
public interface KeystoPngimgMapper 
{
    /**
     * 查询png前端
     * 
     * @param id png前端主键
     * @return png前端
     */
    public KeystoPngimg selectKeystoPngimgById(Long id);

    /**
     * 查询png前端列表
     * 
     * @param keystoPngimg png前端
     * @return png前端集合
     */
    public List<KeystoPngimg> selectKeystoPngimgList(KeystoPngimg keystoPngimg);

    /**
     * 新增png前端
     * 
     * @param keystoPngimg png前端
     * @return 结果
     */
    public int insertKeystoPngimg(KeystoPngimg keystoPngimg);

    /**
     * 修改png前端
     * 
     * @param keystoPngimg png前端
     * @return 结果
     */
    public int updateKeystoPngimg(KeystoPngimg keystoPngimg);

    /**
     * 删除png前端
     * 
     * @param id png前端主键
     * @return 结果
     */
    public int deleteKeystoPngimgById(Long id);

    /**
     * 批量删除png前端
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteKeystoPngimgByIds(String[] ids);
}
