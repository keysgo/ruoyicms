package com.ruoyi.plugs.pv.service.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;

import com.ruoyi.plugs.pv.domain.Pv;
import com.ruoyi.plugs.pv.mapper.PvMapper;
import com.ruoyi.plugs.pv.service.IPvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PVService业务层处理
 *
 * @author wujiyue
 * @date 2019-11-29
 */
@Service
@ConditionalOnProperty(value = "plugs.pv.enable",havingValue = "1",matchIfMissing = false)
public class PvServiceImpl implements IPvService
{
    @Autowired
    private PvMapper pvMapper;

    /**
     * 查询PV
     *
     * @param id PVID
     * @return PV
     */
    @Override
    public Pv selectPvById(Long id)
    {
        return pvMapper.selectPvById(id);
    }

    /**
     * 查询PV列表
     *
     * @param pv PV
     * @return PV
     */
    @Override
    public List<Pv> selectPvList(Pv pv)
    {
        return pvMapper.selectPvList(pv);
    }

    /**
     * 新增PV
     *
     * @param pv PV
     * @return 结果
     */
    @Override
    public int insertPv(Pv pv)
    {
        pv.setCreateTime(DateUtils.getNowDate());
        return pvMapper.insertPv(pv);
    }

    @Override
    public int insertPvBatch(List<Pv> pvs) {
        return pvMapper.insertPvBatch(pvs);
    }

    /**
     * 修改PV
     *
     * @param pv PV
     * @return 结果
     */
    @Override
    public int updatePv(Pv pv)
    {
        pv.setUpdateTime(DateUtils.getNowDate());
        return pvMapper.updatePv(pv);
    }

    /**
     * 删除PV对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePvByIds(String ids)
    {
        return pvMapper.deletePvByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除PV信息
     *
     * @param id PVID
     * @return 结果
     */
    @Override
    public int deletePvById(Long id)
    {
        return pvMapper.deletePvById(id);
    }

}
