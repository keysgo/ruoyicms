package com.ruoyi.keystospider.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 爬虫管理对象 keysto_spider_field
 * 
 * @author keysto
 * @date 2022-11-09
 */
public class KeystoSpiderField extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 字段ID */
    private Long fieldId;

    /** 爬虫配置ID */
    @Excel(name = "爬虫配置ID")
    private Long configId;

    /** 字段 */
    @Excel(name = "字段")
    private String field;

    /** 字段名称 */
    @Excel(name = "字段名称")
    private String fieldName;

    /** 提取类型 */
    @Excel(name = "提取类型")
    private String extractType;

    /** 提取规则2 */
    @Excel(name = "提取规则2")
    private String extractBy;

    /** 提取规则 */
    @Excel(name = "提取规则")
    private String extractBy2;

    /** 常量值 */
    @Excel(name = "常量值")
    private String constantValue;

    /** 元素的索引 */
    @Excel(name = "元素的索引")
    private String extractIndex;

    /** 处理规则 */
    @Excel(name = "处理规则")
    private String processRuleId;

    /** 是否是根据元素取值 */
    @Excel(name = "是否是根据元素取值")
    private String extractAttrFlag;

    /** 根据哪个元素取值 */
    @Excel(name = "根据哪个元素取值")
    private String extractAttr;

    /** 内置字段处理机制 */
    @Excel(name = "内置字段处理机制")
    private String spiderFieldHighSetting;

    /** 内置字段处理机制参数 */
    @Excel(name = "内置字段处理机制参数")
    private String spiderFieldHighSettingParams;

    public void setFieldId(Long fieldId) 
    {
        this.fieldId = fieldId;
    }

    public Long getFieldId() 
    {
        return fieldId;
    }
    public void setConfigId(Long configId) 
    {
        this.configId = configId;
    }

    public Long getConfigId() 
    {
        return configId;
    }
    public void setField(String field) 
    {
        this.field = field;
    }

    public String getField() 
    {
        return field;
    }
    public void setFieldName(String fieldName) 
    {
        this.fieldName = fieldName;
    }

    public String getFieldName() 
    {
        return fieldName;
    }
    public void setExtractType(String extractType) 
    {
        this.extractType = extractType;
    }

    public String getExtractType() 
    {
        return extractType;
    }
    public void setExtractBy(String extractBy) 
    {
        this.extractBy = extractBy;
    }

    public String getExtractBy() 
    {
        return extractBy;
    }
    public void setExtractBy2(String extractBy2) 
    {
        this.extractBy2 = extractBy2;
    }

    public String getExtractBy2() 
    {
        return extractBy2;
    }
    public void setConstantValue(String constantValue) 
    {
        this.constantValue = constantValue;
    }

    public String getConstantValue() 
    {
        return constantValue;
    }
    public void setExtractIndex(String extractIndex) 
    {
        this.extractIndex = extractIndex;
    }

    public String getExtractIndex() 
    {
        return extractIndex;
    }
    public void setProcessRuleId(String processRuleId) 
    {
        this.processRuleId = processRuleId;
    }

    public String getProcessRuleId() 
    {
        return processRuleId;
    }
    public void setExtractAttrFlag(String extractAttrFlag) 
    {
        this.extractAttrFlag = extractAttrFlag;
    }

    public String getExtractAttrFlag() 
    {
        return extractAttrFlag;
    }
    public void setExtractAttr(String extractAttr) 
    {
        this.extractAttr = extractAttr;
    }

    public String getExtractAttr() 
    {
        return extractAttr;
    }
    public void setSpiderFieldHighSetting(String spiderFieldHighSetting) 
    {
        this.spiderFieldHighSetting = spiderFieldHighSetting;
    }

    public String getSpiderFieldHighSetting() 
    {
        return spiderFieldHighSetting;
    }
    public void setSpiderFieldHighSettingParams(String spiderFieldHighSettingParams) 
    {
        this.spiderFieldHighSettingParams = spiderFieldHighSettingParams;
    }

    public String getSpiderFieldHighSettingParams() 
    {
        return spiderFieldHighSettingParams;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fieldId", getFieldId())
            .append("configId", getConfigId())
            .append("field", getField())
            .append("fieldName", getFieldName())
            .append("extractType", getExtractType())
            .append("extractBy", getExtractBy())
            .append("extractBy2", getExtractBy2())
            .append("constantValue", getConstantValue())
            .append("extractIndex", getExtractIndex())
            .append("processRuleId", getProcessRuleId())
            .append("extractAttrFlag", getExtractAttrFlag())
            .append("extractAttr", getExtractAttr())
            .append("spiderFieldHighSetting", getSpiderFieldHighSetting())
            .append("spiderFieldHighSettingParams", getSpiderFieldHighSettingParams())
            .toString();
    }
}
