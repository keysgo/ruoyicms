package com.ruoyi.keystospider.mapper;

import java.util.List;
import com.ruoyi.keystospider.domain.KeystoSpiderMission;

/**
 * 爬虫任务Mapper接口
 * 
 * @author keysto
 * @date 2022-11-09
 */
public interface KeystoSpiderMissionMapper 
{
    /**
     * 查询爬虫任务
     * 
     * @param missionId 爬虫任务主键
     * @return 爬虫任务
     */
    public KeystoSpiderMission selectKeystoSpiderMissionByMissionId(Long missionId);

    /**
     * 查询爬虫任务列表
     * 
     * @param keystoSpiderMission 爬虫任务
     * @return 爬虫任务集合
     */
    public List<KeystoSpiderMission> selectKeystoSpiderMissionList(KeystoSpiderMission keystoSpiderMission);

    /**
     * 新增爬虫任务
     * 
     * @param keystoSpiderMission 爬虫任务
     * @return 结果
     */
    public int insertKeystoSpiderMission(KeystoSpiderMission keystoSpiderMission);

    /**
     * 修改爬虫任务
     * 
     * @param keystoSpiderMission 爬虫任务
     * @return 结果
     */
    public int updateKeystoSpiderMission(KeystoSpiderMission keystoSpiderMission);

    /**
     * 删除爬虫任务
     * 
     * @param missionId 爬虫任务主键
     * @return 结果
     */
    public int deleteKeystoSpiderMissionByMissionId(Long missionId);

    /**
     * 批量删除爬虫任务
     * 
     * @param missionIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteKeystoSpiderMissionByMissionIds(String[] missionIds);
}
