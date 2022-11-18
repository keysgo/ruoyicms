package com.ruoyi.keystospider.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.junit.Test;
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
import com.ruoyi.keystospider.domain.KeystoSpiderConfig;
import com.ruoyi.keystospider.service.IKeystoSpiderConfigService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 爬虫管理Controller
 * 
 * @author keysto
 * @date 2022-11-09
 */
@Controller
@RequestMapping("/keystospider/spider")
public class KeystoSpiderConfigController extends BaseController
{
    private String prefix = "keystospider/spider";

    @Autowired
    private IKeystoSpiderConfigService keystoSpiderConfigService;

    @RequiresPermissions("keystospider:spider:view")
    @GetMapping()
    public String spider()
    {
        return prefix + "/spider";
    }

    /**
     * 查询爬虫管理列表
     */
    @RequiresPermissions("keystospider:spider:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(KeystoSpiderConfig keystoSpiderConfig)
    {
        startPage();
        List<KeystoSpiderConfig> list = keystoSpiderConfigService.selectKeystoSpiderConfigList(keystoSpiderConfig);
        return getDataTable(list);
    }

    /**
     * 导出爬虫管理列表
     */
    @RequiresPermissions("keystospider:spider:export")
    @Log(title = "爬虫管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(KeystoSpiderConfig keystoSpiderConfig)
    {
        List<KeystoSpiderConfig> list = keystoSpiderConfigService.selectKeystoSpiderConfigList(keystoSpiderConfig);
        ExcelUtil<KeystoSpiderConfig> util = new ExcelUtil<KeystoSpiderConfig>(KeystoSpiderConfig.class);
        return util.exportExcel(list, "爬虫管理数据");
    }

    /**
     * 新增爬虫管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存爬虫管理
     */
    @RequiresPermissions("keystospider:spider:add")
    @Log(title = "爬虫管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(KeystoSpiderConfig keystoSpiderConfig)
    {
        return toAjax(keystoSpiderConfigService.insertKeystoSpiderConfig(keystoSpiderConfig));
    }

    /**
     * 修改爬虫管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        KeystoSpiderConfig keystoSpiderConfig = keystoSpiderConfigService.selectKeystoSpiderConfigById(id);
        mmap.put("keystoSpiderConfig", keystoSpiderConfig);
        return prefix + "/edit";
    }

    /**
     * 修改保存爬虫管理
     */
    @RequiresPermissions("keystospider:spider:edit")
    @Log(title = "爬虫管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(KeystoSpiderConfig keystoSpiderConfig)
    {
        return toAjax(keystoSpiderConfigService.updateKeystoSpiderConfig(keystoSpiderConfig));
    }

    /**
     * 删除爬虫管理
     */
    @RequiresPermissions("keystospider:spider:remove")
    @Log(title = "爬虫管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(keystoSpiderConfigService.deleteKeystoSpiderConfigByIds(ids));
    }


}
