package com.ruoyi.home.service;

import java.util.List;
import com.ruoyi.home.domain.KeystoPngimgHome;
import com.ruoyi.home.domain.KeystoPngingType;

/**
 * png前端Service接口
 * 
 * @author keysto
 * @date 2022-11-30
 */
public interface IKeystoPngimgHomeService 
{
    /**
     * 查询png前端
     * 
     * @param id png前端主键
     * @return png前端
     */
    public KeystoPngimgHome selectKeystoPngimgHomeById(Long id);

    /**
     * 查询png前端列表
     * 
     * @param keystoPngimgHome png前端
     * @return png前端集合
     */
    public List<KeystoPngimgHome> selectKeystoPngimgHomeList(KeystoPngimgHome keystoPngimgHome);

    /**
     * 新增png前端
     * 
     * @param keystoPngimgHome png前端
     * @return 结果
     */
    public int insertKeystoPngimgHome(KeystoPngimgHome keystoPngimgHome);

    /**
     * 修改png前端
     * 
     * @param keystoPngimgHome png前端
     * @return 结果
     */
    public int updateKeystoPngimgHome(KeystoPngimgHome keystoPngimgHome);

    /**
     * 批量删除png前端
     * 
     * @param ids 需要删除的png前端主键集合
     * @return 结果
     */
    public int deleteKeystoPngimgHomeByIds(String ids);

    /**
     * 删除png前端信息
     * 
     * @param id png前端主键
     * @return 结果
     */
    public int deleteKeystoPngimgHomeById(Long id);


    /***
     * 查询分类，返回分类数量名称和id
     * @return
     */
    public List<KeystoPngingType>  selectKeystoPngimgTypeList();


}
