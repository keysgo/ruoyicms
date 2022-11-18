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
import com.ruoyi.keystospider.domain.KeystoSpiderFiledRule;
import com.ruoyi.keystospider.service.IKeystoSpiderFiledRuleService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 字段规则Controller
 * 
 * @author keysto
 * @date 2022-11-09
 */
@Controller
@RequestMapping("/keystospider/rule")
public class KeystoSpiderFiledRuleController extends BaseController
{
    private String prefix = "keystospider/rule";

    @Autowired
    private IKeystoSpiderFiledRuleService keystoSpiderFiledRuleService;

    @RequiresPermissions("keystospider:rule:view")
    @GetMapping()
    public String rule()
    {
        return prefix + "/rule";
    }

    /**
     * 查询字段规则列表
     */
    @RequiresPermissions("keystospider:rule:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(KeystoSpiderFiledRule keystoSpiderFiledRule)
    {
        startPage();
        List<KeystoSpiderFiledRule> list = keystoSpiderFiledRuleService.selectKeystoSpiderFiledRuleList(keystoSpiderFiledRule);
        return getDataTable(list);
    }

    /**
     * 导出字段规则列表
     */
    @RequiresPermissions("keystospider:rule:export")
    @Log(title = "字段规则", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(KeystoSpiderFiledRule keystoSpiderFiledRule)
    {
        List<KeystoSpiderFiledRule> list = keystoSpiderFiledRuleService.selectKeystoSpiderFiledRuleList(keystoSpiderFiledRule);
        ExcelUtil<KeystoSpiderFiledRule> util = new ExcelUtil<KeystoSpiderFiledRule>(KeystoSpiderFiledRule.class);
        return util.exportExcel(list, "字段规则数据");
    }

    /**
     * 新增字段规则
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存字段规则
     */
    @RequiresPermissions("keystospider:rule:add")
    @Log(title = "字段规则", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(KeystoSpiderFiledRule keystoSpiderFiledRule)
    {
        return toAjax(keystoSpiderFiledRuleService.insertKeystoSpiderFiledRule(keystoSpiderFiledRule));
    }

    /**
     * 修改字段规则
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        KeystoSpiderFiledRule keystoSpiderFiledRule = keystoSpiderFiledRuleService.selectKeystoSpiderFiledRuleById(id);
        mmap.put("keystoSpiderFiledRule", keystoSpiderFiledRule);
        return prefix + "/edit";
    }

    /**
     * 修改保存字段规则
     */
    @RequiresPermissions("keystospider:rule:edit")
    @Log(title = "字段规则", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(KeystoSpiderFiledRule keystoSpiderFiledRule)
    {
        return toAjax(keystoSpiderFiledRuleService.updateKeystoSpiderFiledRule(keystoSpiderFiledRule));
    }

    /**
     * 删除字段规则
     */
    @RequiresPermissions("keystospider:rule:remove")
    @Log(title = "字段规则", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(keystoSpiderFiledRuleService.deleteKeystoSpiderFiledRuleByIds(ids));
    }
}
