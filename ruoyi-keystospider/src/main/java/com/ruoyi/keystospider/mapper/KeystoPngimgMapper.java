package com.ruoyi.keystospider.mapper;

import java.util.List;
import com.ruoyi.keystospider.domain.KeystoPngimg;

/**
 * png管理Mapper接口
 * 
 * @author keysto
 * @date 2022-11-27
 */
public interface KeystoPngimgMapper 
{
    /**
     * 查询png管理
     * 
     * @param id png管理主键
     * @return png管理
     */
    public KeystoPngimg selectKeystoPngimgById(Long id);

    /**
     * 查询png管理列表
     * 
     * @param keystoPngimg png管理
     * @return png管理集合
     */
    public List<KeystoPngimg> selectKeystoPngimgList(KeystoPngimg keystoPngimg);

    /**
     * 新增png管理
     * 
     * @param keystoPngimg png管理
     * @return 结果
     */
    public int insertKeystoPngimg(KeystoPngimg keystoPngimg);

    /**
     * 修改png管理
     * 
     * @param keystoPngimg png管理
     * @return 结果
     */
    public int updateKeystoPngimg(KeystoPngimg keystoPngimg);

    /**
     * 删除png管理
     * 
     * @param id png管理主键
     * @return 结果
     */
    public int deleteKeystoPngimgById(Long id);

    /**
     * 批量删除png管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteKeystoPngimgByIds(String[] ids);
}
