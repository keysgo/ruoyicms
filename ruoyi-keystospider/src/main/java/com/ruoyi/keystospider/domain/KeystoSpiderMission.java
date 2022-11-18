package com.ruoyi.keystospider.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 爬虫任务对象 keystospider_mission
 * 
 * @author keysto
 * @date 2022-11-09
 */
public class KeystoSpiderMission extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 爬虫任务ID */
    private Long missionId;

    /** 任务名称 */
    @Excel(name = "任务名称")
    private String missionName;

    /** 爬虫配置ID */
    @Excel(name = "爬虫配置ID")
    private Long spiderConfigId;

    /** 入口地址 */
    @Excel(name = "入口地址")
    private String entryUrls;

    /** 任务状态 */
    @Excel(name = "任务状态")
    private String status;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 爬取时间(单位秒) */
    @Excel(name = "爬取时间(单位秒)")
    private String timeCost;

    /** 退出方式。DEFAULT，DURATION，URL_COUNT。 */
    @Excel(name = "退出方式。DEFAULT，DURATION，URL_COUNT。")
    private String exitWay;

    /** 退出方式值 */
    @Excel(name = "退出方式值")
    private Long exitWayCount;

    /** 爬取数量 */
    @Excel(name = "爬取数量")
    private Long successNum;

    /** cookie */
    @Excel(name = "cookie")
    private String cookieStr;

    /**  */
    @Excel(name = "")
    private String headerStr;

    /** 部门ID */
    @Excel(name = "部门ID")
    private String deptId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private String userId;

    /** 翻页标志 */
    @Excel(name = "翻页标志")
    private Integer loopFlag;

    /** 翻页参数  如URL 后追加 &page=5来控制翻页 */
    @Excel(name = "翻页参数  如URL 后追加 &page=5来控制翻页")
    private String loopParam;

    /** 循环次数 URL翻页用 */
    @Excel(name = "循环次数 URL翻页用")
    private Integer loopNum;

    public void setMissionId(Long missionId) 
    {
        this.missionId = missionId;
    }

    public Long getMissionId() 
    {
        return missionId;
    }
    public void setMissionName(String missionName) 
    {
        this.missionName = missionName;
    }

    public String getMissionName() 
    {
        return missionName;
    }
    public void setSpiderConfigId(Long spiderConfigId) 
    {
        this.spiderConfigId = spiderConfigId;
    }

    public Long getSpiderConfigId() 
    {
        return spiderConfigId;
    }
    public void setEntryUrls(String entryUrls) 
    {
        this.entryUrls = entryUrls;
    }

    public String getEntryUrls() 
    {
        return entryUrls;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setTimeCost(String timeCost) 
    {
        this.timeCost = timeCost;
    }

    public String getTimeCost() 
    {
        return timeCost;
    }
    public void setExitWay(String exitWay) 
    {
        this.exitWay = exitWay;
    }

    public String getExitWay() 
    {
        return exitWay;
    }
    public void setExitWayCount(Long exitWayCount) 
    {
        this.exitWayCount = exitWayCount;
    }

    public Long getExitWayCount() 
    {
        return exitWayCount;
    }
    public void setSuccessNum(Long successNum) 
    {
        this.successNum = successNum;
    }

    public Long getSuccessNum() 
    {
        return successNum;
    }
    public void setCookieStr(String cookieStr) 
    {
        this.cookieStr = cookieStr;
    }

    public String getCookieStr() 
    {
        return cookieStr;
    }
    public void setHeaderStr(String headerStr) 
    {
        this.headerStr = headerStr;
    }

    public String getHeaderStr() 
    {
        return headerStr;
    }
    public void setDeptId(String deptId) 
    {
        this.deptId = deptId;
    }

    public String getDeptId() 
    {
        return deptId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setLoopFlag(Integer loopFlag) 
    {
        this.loopFlag = loopFlag;
    }

    public Integer getLoopFlag() 
    {
        return loopFlag;
    }
    public void setLoopParam(String loopParam) 
    {
        this.loopParam = loopParam;
    }

    public String getLoopParam() 
    {
        return loopParam;
    }
    public void setLoopNum(Integer loopNum) 
    {
        this.loopNum = loopNum;
    }

    public Integer getLoopNum() 
    {
        return loopNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("missionId", getMissionId())
            .append("missionName", getMissionName())
            .append("spiderConfigId", getSpiderConfigId())
            .append("entryUrls", getEntryUrls())
            .append("status", getStatus())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("timeCost", getTimeCost())
            .append("exitWay", getExitWay())
            .append("exitWayCount", getExitWayCount())
            .append("successNum", getSuccessNum())
            .append("cookieStr", getCookieStr())
            .append("headerStr", getHeaderStr())
            .append("deptId", getDeptId())
            .append("userId", getUserId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("loopFlag", getLoopFlag())
            .append("loopParam", getLoopParam())
            .append("loopNum", getLoopNum())
            .toString();
    }
}
