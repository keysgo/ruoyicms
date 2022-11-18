package com.ruoyi.keystospider.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.keystospider.domain.KeystoSpiderMission;
import com.ruoyi.keystospider.service.IKeystoSpiderMissionService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 爬虫任务Controller
 * 
 * @author keysto
 * @date 2022-11-09
 */
@Controller
@RequestMapping("/keystospider/mission")
public class KeystoSpiderMissionController extends BaseController
{
    private String prefix = "keystospider/mission";

    @Autowired
    private IKeystoSpiderMissionService keystoSpiderMissionService;

    @RequiresPermissions("keystospider:mission:view")
    @GetMapping()
    public String mission()
    {
        return prefix + "/mission";
    }

    /**
     * 查询爬虫任务列表
     */
    @RequiresPermissions("keystospider:mission:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(KeystoSpiderMission keystoSpiderMission)
    {
        startPage();
        List<KeystoSpiderMission> list = keystoSpiderMissionService.selectKeystoSpiderMissionList(keystoSpiderMission);
        return getDataTable(list);
    }

    /**
     * 导出爬虫任务列表
     */
    @RequiresPermissions("keystospider:mission:export")
    @Log(title = "爬虫任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(KeystoSpiderMission keystoSpiderMission)
    {
        List<KeystoSpiderMission> list = keystoSpiderMissionService.selectKeystoSpiderMissionList(keystoSpiderMission);
        ExcelUtil<KeystoSpiderMission> util = new ExcelUtil<KeystoSpiderMission>(KeystoSpiderMission.class);
        return util.exportExcel(list, "爬虫任务数据");
    }

    /**
     * 新增爬虫任务
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存爬虫任务
     */
    @RequiresPermissions("keystospider:mission:add")
    @Log(title = "爬虫任务", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(KeystoSpiderMission keystoSpiderMission)
    {
        return toAjax(keystoSpiderMissionService.insertKeystoSpiderMission(keystoSpiderMission));
    }

    /**
     * 修改爬虫任务
     */
    @GetMapping("/edit/{missionId}")
    public String edit(@PathVariable("missionId") Long missionId, ModelMap mmap)
    {
        KeystoSpiderMission keystoSpiderMission = keystoSpiderMissionService.selectKeystoSpiderMissionByMissionId(missionId);
        mmap.put("keystoSpiderMission", keystoSpiderMission);
        return prefix + "/edit";
    }

    /**
     * 修改保存爬虫任务
     */
    @RequiresPermissions("keystospider:mission:edit")
    @Log(title = "爬虫任务", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(KeystoSpiderMission keystoSpiderMission)
    {
        return toAjax(keystoSpiderMissionService.updateKeystoSpiderMission(keystoSpiderMission));
    }

    /**
     * 删除爬虫任务
     */
    @RequiresPermissions("keystospider:mission:remove")
    @Log(title = "爬虫任务", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(keystoSpiderMissionService.deleteKeystoSpiderMissionByMissionIds(ids));
    }
}
