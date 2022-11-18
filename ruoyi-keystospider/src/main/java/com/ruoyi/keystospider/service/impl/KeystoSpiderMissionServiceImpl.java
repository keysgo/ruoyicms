package com.ruoyi.keystospider.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.keystospider.mapper.KeystoSpiderMissionMapper;
import com.ruoyi.keystospider.domain.KeystoSpiderMission;
import com.ruoyi.keystospider.service.IKeystoSpiderMissionService;
import com.ruoyi.common.core.text.Convert;

/**
 * 爬虫任务Service业务层处理
 * 
 * @author keysto
 * @date 2022-11-09
 */
@Service
public class KeystoSpiderMissionServiceImpl implements IKeystoSpiderMissionService 
{
    @Autowired
    private KeystoSpiderMissionMapper keystoSpiderMissionMapper;

    /**
     * 查询爬虫任务
     * 
     * @param missionId 爬虫任务主键
     * @return 爬虫任务
     */
    @Override
    public KeystoSpiderMission selectKeystoSpiderMissionByMissionId(Long missionId)
    {
        return keystoSpiderMissionMapper.selectKeystoSpiderMissionByMissionId(missionId);
    }

    /**
     * 查询爬虫任务列表
     * 
     * @param keystoSpiderMission 爬虫任务
     * @return 爬虫任务
     */
    @Override
    public List<KeystoSpiderMission> selectKeystoSpiderMissionList(KeystoSpiderMission keystoSpiderMission)
    {
        return keystoSpiderMissionMapper.selectKeystoSpiderMissionList(keystoSpiderMission);
    }

    /**
     * 新增爬虫任务
     * 
     * @param keystoSpiderMission 爬虫任务
     * @return 结果
     */
    @Override
    public int insertKeystoSpiderMission(KeystoSpiderMission keystoSpiderMission)
    {
        keystoSpiderMission.setCreateTime(DateUtils.getNowDate());
        return keystoSpiderMissionMapper.insertKeystoSpiderMission(keystoSpiderMission);
    }

    /**
     * 修改爬虫任务
     * 
     * @param keystoSpiderMission 爬虫任务
     * @return 结果
     */
    @Override
    public int updateKeystoSpiderMission(KeystoSpiderMission keystoSpiderMission)
    {
        return keystoSpiderMissionMapper.updateKeystoSpiderMission(keystoSpiderMission);
    }

    /**
     * 批量删除爬虫任务
     * 
     * @param missionIds 需要删除的爬虫任务主键
     * @return 结果
     */
    @Override
    public int deleteKeystoSpiderMissionByMissionIds(String missionIds)
    {
        return keystoSpiderMissionMapper.deleteKeystoSpiderMissionByMissionIds(Convert.toStrArray(missionIds));
    }

    /**
     * 删除爬虫任务信息
     * 
     * @param missionId 爬虫任务主键
     * @return 结果
     */
    @Override
    public int deleteKeystoSpiderMissionByMissionId(Long missionId)
    {
        return keystoSpiderMissionMapper.deleteKeystoSpiderMissionByMissionId(missionId);
    }
}
