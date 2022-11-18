package com.ruoyi.test.controller;

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
import com.ruoyi.test.domain.TestXixin;
import com.ruoyi.test.service.ITestXixinService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 个人信息Controller
 * 
 * @author ruoyi
 * @date 2022-11-09
 */
@Controller
@RequestMapping("/test/xixin")
public class TestXixinController extends BaseController
{
    private String prefix = "test/xixin";

    @Autowired
    private ITestXixinService testXixinService;

    @RequiresPermissions("test:xixin:view")
    @GetMapping()
    public String xixin()
    {
        return prefix + "/xixin";
    }

    /**
     * 查询个人信息列表
     */
    @RequiresPermissions("test:xixin:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TestXixin testXixin)
    {
        startPage();
        List<TestXixin> list = testXixinService.selectTestXixinList(testXixin);
        return getDataTable(list);
    }

    /**
     * 导出个人信息列表
     */
    @RequiresPermissions("test:xixin:export")
    @Log(title = "个人信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TestXixin testXixin)
    {
        List<TestXixin> list = testXixinService.selectTestXixinList(testXixin);
        ExcelUtil<TestXixin> util = new ExcelUtil<TestXixin>(TestXixin.class);
        return util.exportExcel(list, "个人信息数据");
    }

    /**
     * 新增个人信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存个人信息
     */
    @RequiresPermissions("test:xixin:add")
    @Log(title = "个人信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TestXixin testXixin)
    {
        return toAjax(testXixinService.insertTestXixin(testXixin));
    }

    /**
     * 修改个人信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TestXixin testXixin = testXixinService.selectTestXixinById(id);
        mmap.put("testXixin", testXixin);
        return prefix + "/edit";
    }

    /**
     * 修改保存个人信息
     */
    @RequiresPermissions("test:xixin:edit")
    @Log(title = "个人信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TestXixin testXixin)
    {
        return toAjax(testXixinService.updateTestXixin(testXixin));
    }

    /**
     * 删除个人信息
     */
    @RequiresPermissions("test:xixin:remove")
    @Log(title = "个人信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(testXixinService.deleteTestXixinByIds(ids));
    }
}
