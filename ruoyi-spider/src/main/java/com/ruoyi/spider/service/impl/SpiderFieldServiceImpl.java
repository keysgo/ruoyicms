package com.ruoyi.spider.service.impl;

import java.util.List;

import com.ruoyi.spider.service.ISpiderFiledRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.spider.mapper.SpiderFieldMapper;
import com.ruoyi.spider.domain.SpiderField;
import com.ruoyi.spider.service.ISpiderFieldService;
import com.ruoyi.common.core.text.Convert;

/**
 * 爬虫字段Service业务层处理
 *
 * @author wujiyue
 * @date 2019-11-12
 */
@Service
public class SpiderFieldServiceImpl implements ISpiderFieldService
{
    @Autowired
    private SpiderFieldMapper spiderFieldMapper;
    @Autowired
    private ISpiderFiledRuleService spiderFiledRuleService;
    /**
     * 查询爬虫字段
     *
     * @param fieldId 爬虫字段ID
     * @return 爬虫字段
     */
    @Override
    public SpiderField selectSpiderFieldById(Long fieldId)
    {
        return spiderFieldMapper.selectSpiderFieldById(fieldId);
    }

    /**
     * 查询爬虫字段列表
     *
     * @param spiderField 爬虫字段
     * @return 爬虫字段
     */
    @Override
    public List<SpiderField> selectSpiderFieldList(SpiderField spiderField)
    {
        return spiderFieldMapper.selectSpiderFieldList(spiderField);
    }

    /**
     * 新增爬虫字段
     *
     * @param spiderField 爬虫字段
     * @return 结果
     */
    @Override
    public int insertSpiderField(SpiderField spiderField)
    {
        return spiderFieldMapper.insertSpiderField(spiderField);
    }

    /**
     * 修改爬虫字段
     *
     * @param spiderField 爬虫字段
     * @return 结果
     */
    @Override
    public int updateSpiderField(SpiderField spiderField)
    {
        return spiderFieldMapper.updateSpiderField(spiderField);
    }

    /**
     * 删除爬虫字段对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSpiderFieldByIds(String ids)
    {
        String[] arr=Convert.toStrArray(ids);
        for(String id:arr){
            spiderFiledRuleService.deleteSpiderFiledRuleByFieldId(id);
        }
        return spiderFieldMapper.deleteSpiderFieldByIds(arr);
    }

    /**
     * 删除爬虫字段信息
     *
     * @param fieldId 爬虫字段ID
     * @return 结果
     */
    @Override
    public int deleteSpiderFieldById(Long fieldId)
    {
        spiderFiledRuleService.deleteSpiderFiledRuleByFieldId(fieldId.toString());
        return spiderFieldMapper.deleteSpiderFieldById(fieldId);
    }

    @Override
    public int deleteSpiderFieldByConfigId(Long configId) {
        SpiderField form=new SpiderField();
        form.setConfigId(configId);
        List<SpiderField> fieldList=this.selectSpiderFieldList(form);
        for(SpiderField field:fieldList){
            this.deleteSpiderFieldById(field.getFieldId());
        }
        return spiderFieldMapper.deleteSpiderFieldByConfigId(configId);
    }
}
