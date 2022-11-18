package com.ruoyi.keystospider.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 爬虫管理对象 keystospider_config
 * 
 * @author keysto
 * @date 2022-11-09
 */
public class KeystoSpiderConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 爬虫配置ID */
    private Long id;

    /** 爬虫编码 */
    @Excel(name = "爬虫编码")
    private String spiderCode;

    /** 爬虫名称 */
    @Excel(name = "爬虫名称")
    private String spiderName;

    /** 入口地址 */
    @Excel(name = "入口地址")
    private String entryUrls;

    /** 目标URL正则 */
    @Excel(name = "目标URL正则")
    private String targetRegex;

    /** 1:级联发现url  0:只从入口页面发现url */
    @Excel(name = "1:级联发现url  0:只从入口页面发现url")
    private Integer cascade;

    /** 存储的表名 */
    @Excel(name = "存储的表名")
    private String tableName;

    /** 网站根域名 */
    @Excel(name = "网站根域名")
    private String domain;

    /** 字符集 */
    @Excel(name = "字符集")
    private String charset;

    /** 睡眠时间(ms) */
    @Excel(name = "睡眠时间(ms)")
    private Long sleepTime;

    /** 重试次数 */
    @Excel(name = "重试次数")
    private Integer retryTimes;

    /** 线程数量 */
    @Excel(name = "线程数量")
    private Long threadCount;

    /** 使用代理 */
    @Excel(name = "使用代理")
    private Integer useProxy;

    /** 打印日志 */
    @Excel(name = "打印日志")
    private Integer showLog;

    /** 保存到数据库 */
    @Excel(name = "保存到数据库")
    private Integer saveDb;

    /** 是否json接口请求 */
    @Excel(name = "是否json接口请求")
    private Integer isJson;

    /** 爬虫高级设置 */
    @Excel(name = "爬虫高级设置")
    private String spiderHighSetting;

    /** 用户自定义pepeline */
    @Excel(name = "用户自定义pepeline")
    private String userDefinePipeline;

    /**  */
    @Excel(name = "")
    private Integer isSelenium;

    /** 任务结束回调 */
    @Excel(name = "任务结束回调")
    private String missionFinish;

    /** 列表提取规则 */
    @Excel(name = "列表提取规则")
    private String listExtractBy;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSpiderCode(String spiderCode) 
    {
        this.spiderCode = spiderCode;
    }

    public String getSpiderCode() 
    {
        return spiderCode;
    }
    public void setSpiderName(String spiderName) 
    {
        this.spiderName = spiderName;
    }

    public String getSpiderName() 
    {
        return spiderName;
    }
    public void setEntryUrls(String entryUrls) 
    {
        this.entryUrls = entryUrls;
    }

    public String getEntryUrls() 
    {
        return entryUrls;
    }
    public void setTargetRegex(String targetRegex) 
    {
        this.targetRegex = targetRegex;
    }

    public String getTargetRegex() 
    {
        return targetRegex;
    }
    public void setCascade(Integer cascade) 
    {
        this.cascade = cascade;
    }

    public Integer getCascade() 
    {
        return cascade;
    }
    public void setTableName(String tableName) 
    {
        this.tableName = tableName;
    }

    public String getTableName() 
    {
        return tableName;
    }
    public void setDomain(String domain) 
    {
        this.domain = domain;
    }

    public String getDomain() 
    {
        return domain;
    }
    public void setCharset(String charset) 
    {
        this.charset = charset;
    }

    public String getCharset() 
    {
        return charset;
    }
    public void setSleepTime(Long sleepTime) 
    {
        this.sleepTime = sleepTime;
    }

    public Long getSleepTime() 
    {
        return sleepTime;
    }
    public void setRetryTimes(Integer retryTimes) 
    {
        this.retryTimes = retryTimes;
    }

    public Integer getRetryTimes() 
    {
        return retryTimes;
    }
    public void setThreadCount(Long threadCount) 
    {
        this.threadCount = threadCount;
    }

    public Long getThreadCount() 
    {
        return threadCount;
    }
    public void setUseProxy(Integer useProxy) 
    {
        this.useProxy = useProxy;
    }

    public Integer getUseProxy() 
    {
        return useProxy;
    }
    public void setShowLog(Integer showLog) 
    {
        this.showLog = showLog;
    }

    public Integer getShowLog() 
    {
        return showLog;
    }
    public void setSaveDb(Integer saveDb) 
    {
        this.saveDb = saveDb;
    }

    public Integer getSaveDb() 
    {
        return saveDb;
    }
    public void setIsJson(Integer isJson) 
    {
        this.isJson = isJson;
    }

    public Integer getIsJson() 
    {
        return isJson;
    }
    public void setSpiderHighSetting(String spiderHighSetting) 
    {
        this.spiderHighSetting = spiderHighSetting;
    }

    public String getSpiderHighSetting() 
    {
        return spiderHighSetting;
    }
    public void setUserDefinePipeline(String userDefinePipeline) 
    {
        this.userDefinePipeline = userDefinePipeline;
    }

    public String getUserDefinePipeline() 
    {
        return userDefinePipeline;
    }
    public void setIsSelenium(Integer isSelenium) 
    {
        this.isSelenium = isSelenium;
    }

    public Integer getIsSelenium() 
    {
        return isSelenium;
    }
    public void setMissionFinish(String missionFinish) 
    {
        this.missionFinish = missionFinish;
    }

    public String getMissionFinish() 
    {
        return missionFinish;
    }
    public void setListExtractBy(String listExtractBy) 
    {
        this.listExtractBy = listExtractBy;
    }

    public String getListExtractBy() 
    {
        return listExtractBy;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("spiderCode", getSpiderCode())
            .append("spiderName", getSpiderName())
            .append("entryUrls", getEntryUrls())
            .append("targetRegex", getTargetRegex())
            .append("cascade", getCascade())
            .append("tableName", getTableName())
            .append("domain", getDomain())
            .append("charset", getCharset())
            .append("sleepTime", getSleepTime())
            .append("retryTimes", getRetryTimes())
            .append("threadCount", getThreadCount())
            .append("useProxy", getUseProxy())
            .append("showLog", getShowLog())
            .append("saveDb", getSaveDb())
            .append("isJson", getIsJson())
            .append("spiderHighSetting", getSpiderHighSetting())
            .append("userDefinePipeline", getUserDefinePipeline())
            .append("isSelenium", getIsSelenium())
            .append("missionFinish", getMissionFinish())
            .append("listExtractBy", getListExtractBy())
            .toString();
    }
}
