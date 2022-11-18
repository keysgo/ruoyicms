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
import com.ruoyi.keystospider.domain.KeystoProduct;
import com.ruoyi.keystospider.service.IKeystoProductService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 亚马逊产品Controller
 * 
 * @author keysto
 * @date 2022-11-16
 */
@Controller
@RequestMapping("/keystospider/product")
public class KeystoProductController extends BaseController
{
    private String prefix = "keystospider/product";

    @Autowired
    private IKeystoProductService keystoProductService;

    @RequiresPermissions("keystospider:product:view")
    @GetMapping()
    public String product()
    {
        return prefix + "/product";
    }

    /**
     * 查询亚马逊产品列表
     */
    @RequiresPermissions("keystospider:product:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(KeystoProduct keystoProduct)
    {
        startPage();
        List<KeystoProduct> list = keystoProductService.selectKeystoProductList(keystoProduct);
        return getDataTable(list);
    }

    /**
     * 导出亚马逊产品列表
     */
    @RequiresPermissions("keystospider:product:export")
    @Log(title = "亚马逊产品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(KeystoProduct keystoProduct)
    {
        List<KeystoProduct> list = keystoProductService.selectKeystoProductList(keystoProduct);
        ExcelUtil<KeystoProduct> util = new ExcelUtil<KeystoProduct>(KeystoProduct.class);
        return util.exportExcel(list, "亚马逊产品数据");
    }

    /**
     * 新增亚马逊产品
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存亚马逊产品
     */
    @RequiresPermissions("keystospider:product:add")
    @Log(title = "亚马逊产品", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(KeystoProduct keystoProduct)
    {
        return toAjax(keystoProductService.insertKeystoProduct(keystoProduct));
    }

    /**
     * 修改亚马逊产品
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        KeystoProduct keystoProduct = keystoProductService.selectKeystoProductById(id);
        mmap.put("keystoProduct", keystoProduct);
        return prefix + "/edit";
    }

    /**
     * 修改保存亚马逊产品
     */
    @RequiresPermissions("keystospider:product:edit")
    @Log(title = "亚马逊产品", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(KeystoProduct keystoProduct)
    {
        return toAjax(keystoProductService.updateKeystoProduct(keystoProduct));
    }

    /**
     * 删除亚马逊产品
     */
    @RequiresPermissions("keystospider:product:remove")
    @Log(title = "亚马逊产品", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(keystoProductService.deleteKeystoProductByIds(ids));
    }
}
