package com.ruoyi.home.controller;

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
import com.ruoyi.home.domain.KeystoPngimg;
import com.ruoyi.home.service.IKeystoPngimgService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * png前端Controller
 * 
 * @author ruoyi
 * @date 2022-11-30
 */
@Controller
@RequestMapping("/home/pnghome")
public class KeystoPngimgController extends BaseController
{
    private String prefix = "home/pnghome";

    @Autowired
    private IKeystoPngimgService keystoPngimgService;

    @RequiresPermissions("home:pnghome:view")
    @GetMapping()
    public String pnghome()
    {
        return prefix + "/pnghome";
    }

    /**
     * 查询png前端列表
     */
    @RequiresPermissions("home:pnghome:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(KeystoPngimg keystoPngimg)
    {
        startPage();
        List<KeystoPngimg> list = keystoPngimgService.selectKeystoPngimgList(keystoPngimg);
        return getDataTable(list);
    }

    /**
     * 导出png前端列表
     */
    @RequiresPermissions("home:pnghome:export")
    @Log(title = "png前端", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(KeystoPngimg keystoPngimg)
    {
        List<KeystoPngimg> list = keystoPngimgService.selectKeystoPngimgList(keystoPngimg);
        ExcelUtil<KeystoPngimg> util = new ExcelUtil<KeystoPngimg>(KeystoPngimg.class);
        return util.exportExcel(list, "png前端数据");
    }

    /**
     * 新增png前端
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存png前端
     */
    @RequiresPermissions("home:pnghome:add")
    @Log(title = "png前端", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(KeystoPngimg keystoPngimg)
    {
        return toAjax(keystoPngimgService.insertKeystoPngimg(keystoPngimg));
    }

    /**
     * 修改png前端
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        KeystoPngimg keystoPngimg = keystoPngimgService.selectKeystoPngimgById(id);
        mmap.put("keystoPngimg", keystoPngimg);
        return prefix + "/edit";
    }

    /**
     * 修改保存png前端
     */
    @RequiresPermissions("home:pnghome:edit")
    @Log(title = "png前端", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(KeystoPngimg keystoPngimg)
    {
        return toAjax(keystoPngimgService.updateKeystoPngimg(keystoPngimg));
    }

    /**
     * 删除png前端
     */
    @RequiresPermissions("home:pnghome:remove")
    @Log(title = "png前端", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(keystoPngimgService.deleteKeystoPngimgByIds(ids));
    }
}
