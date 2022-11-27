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
import com.ruoyi.keystospider.domain.KeystoPngimg;
import com.ruoyi.keystospider.service.IKeystoPngimgService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * png管理Controller
 * 
 * @author keysto
 * @date 2022-11-27
 */
@Controller
@RequestMapping("/KeystoSpider/pngimg")
public class KeystoPngimgController extends BaseController
{
    private String prefix = "KeystoSpider/pngimg";

    @Autowired
    private IKeystoPngimgService keystoPngimgService;

    @RequiresPermissions("KeystoSpider:pngimg:view")
    @GetMapping()
    public String pngimg()
    {
        return prefix + "/pngimg";
    }

    /**
     * 查询png管理列表
     */
    @RequiresPermissions("KeystoSpider:pngimg:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(KeystoPngimg keystoPngimg)
    {
        startPage();
        List<KeystoPngimg> list = keystoPngimgService.selectKeystoPngimgList(keystoPngimg);
        return getDataTable(list);
    }

    /**
     * 导出png管理列表
     */
    @RequiresPermissions("KeystoSpider:pngimg:export")
    @Log(title = "png管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(KeystoPngimg keystoPngimg)
    {
        List<KeystoPngimg> list = keystoPngimgService.selectKeystoPngimgList(keystoPngimg);
        ExcelUtil<KeystoPngimg> util = new ExcelUtil<KeystoPngimg>(KeystoPngimg.class);
        return util.exportExcel(list, "png管理数据");
    }

    /**
     * 新增png管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存png管理
     */
    @RequiresPermissions("KeystoSpider:pngimg:add")
    @Log(title = "png管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(KeystoPngimg keystoPngimg)
    {
        return toAjax(keystoPngimgService.insertKeystoPngimg(keystoPngimg));
    }

    /**
     * 修改png管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        KeystoPngimg keystoPngimg = keystoPngimgService.selectKeystoPngimgById(id);
        mmap.put("keystoPngimg", keystoPngimg);
        return prefix + "/edit";
    }

    /**
     * 修改保存png管理
     */
    @RequiresPermissions("KeystoSpider:pngimg:edit")
    @Log(title = "png管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(KeystoPngimg keystoPngimg)
    {
        return toAjax(keystoPngimgService.updateKeystoPngimg(keystoPngimg));
    }

    /**
     * 删除png管理
     */
    @RequiresPermissions("KeystoSpider:pngimg:remove")
    @Log(title = "png管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(keystoPngimgService.deleteKeystoPngimgByIds(ids));
    }
}
