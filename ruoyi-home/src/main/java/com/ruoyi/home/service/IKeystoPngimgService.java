package com.ruoyi.home.service;

import java.util.List;
import com.ruoyi.home.domain.KeystoPngimg;

/**
 * png前端Service接口
 * 
 * @author ruoyi
 * @date 2022-11-30
 */
public interface IKeystoPngimgService 
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
     * 批量删除png前端
     * 
     * @param ids 需要删除的png前端主键集合
     * @return 结果
     */
    public int deleteKeystoPngimgByIds(String ids);

    /**
     * 删除png前端信息
     * 
     * @param id png前端主键
     * @return 结果
     */
    public int deleteKeystoPngimgById(Long id);
}
