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
import com.ruoyi.keystospider.domain.KeystoSpiderField;
import com.ruoyi.keystospider.service.IKeystoSpiderFieldService;
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
@RequestMapping("/keystospider/field")
public class KeystoSpiderFieldController extends BaseController
{
    private String prefix = "keystospider/field";

    @Autowired
    private IKeystoSpiderFieldService keystoSpiderFieldService;

    @RequiresPermissions("keystospider:field:view")
    @GetMapping()
    public String field()
    {
        return prefix + "/field";
    }

    /**
     * 查询爬虫管理列表
     */
    @RequiresPermissions("keystospider:field:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(KeystoSpiderField keystoSpiderField)
    {
        startPage();
        List<KeystoSpiderField> list = keystoSpiderFieldService.selectKeystoSpiderFieldList(keystoSpiderField);
        return getDataTable(list);
    }

    /**
     * 导出爬虫管理列表
     */
    @RequiresPermissions("keystospider:field:export")
    @Log(title = "爬虫管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(KeystoSpiderField keystoSpiderField)
    {
        List<KeystoSpiderField> list = keystoSpiderFieldService.selectKeystoSpiderFieldList(keystoSpiderField);
        ExcelUtil<KeystoSpiderField> util = new ExcelUtil<KeystoSpiderField>(KeystoSpiderField.class);
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
    @RequiresPermissions("keystospider:field:add")
    @Log(title = "爬虫管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(KeystoSpiderField keystoSpiderField)
    {
        return toAjax(keystoSpiderFieldService.insertKeystoSpiderField(keystoSpiderField));
    }

    /**
     * 修改爬虫管理
     */
    @GetMapping("/edit/{fieldId}")
    public String edit(@PathVariable("fieldId") Long fieldId, ModelMap mmap)
    {
        KeystoSpiderField keystoSpiderField = keystoSpiderFieldService.selectKeystoSpiderFieldByFieldId(fieldId);
        mmap.put("keystoSpiderField", keystoSpiderField);
        return prefix + "/edit";
    }

    /**
     * 修改保存爬虫管理
     */
    @RequiresPermissions("keystospider:field:edit")
    @Log(title = "爬虫管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(KeystoSpiderField keystoSpiderField)
    {
        return toAjax(keystoSpiderFieldService.updateKeystoSpiderField(keystoSpiderField));
    }

    /**
     * 删除爬虫管理
     */
    @RequiresPermissions("keystospider:field:remove")
    @Log(title = "爬虫管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(keystoSpiderFieldService.deleteKeystoSpiderFieldByFieldIds(ids));
    }
}
