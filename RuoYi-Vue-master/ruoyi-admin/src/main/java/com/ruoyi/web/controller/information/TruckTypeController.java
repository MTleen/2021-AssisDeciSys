package com.ruoyi.information.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.information.domain.TruckType;
import com.ruoyi.information.service.ITruckTypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 消防车类型管理Controller
 * 
 * @author Mathripper
 * @date 2021-10-20
 */
@RestController
@RequestMapping("/information/trucktype")
public class TruckTypeController extends BaseController
{
    @Autowired
    private ITruckTypeService truckTypeService;

    /**
     * 查询消防车类型管理列表
     */
    @PreAuthorize("@ss.hasPermi('information:trucktype:list')")
    @GetMapping("/list")
    public TableDataInfo list(TruckType truckType)
    {
        startPage();
        List<TruckType> list = truckTypeService.selectTruckTypeList(truckType);
        return getDataTable(list);
    }

    /**
     * 导出消防车类型管理列表
     */
    @PreAuthorize("@ss.hasPermi('information:trucktype:export')")
    @Log(title = "消防车类型管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TruckType truckType)
    {
        List<TruckType> list = truckTypeService.selectTruckTypeList(truckType);
        ExcelUtil<TruckType> util = new ExcelUtil<TruckType>(TruckType.class);
        return util.exportExcel(list, "消防车类型管理数据");
    }

    /**
     * 获取消防车类型管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('information:trucktype:query')")
    @GetMapping(value = "/{typeid}")
    public AjaxResult getInfo(@PathVariable("typeid") Long typeid)
    {
        return AjaxResult.success(truckTypeService.selectTruckTypeByTypeid(typeid));
    }

    /**
     * 新增消防车类型管理
     */
    @PreAuthorize("@ss.hasPermi('information:trucktype:add')")
    @Log(title = "消防车类型管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TruckType truckType)
    {
        return toAjax(truckTypeService.insertTruckType(truckType));
    }

    /**
     * 修改消防车类型管理
     */
    @PreAuthorize("@ss.hasPermi('information:trucktype:edit')")
    @Log(title = "消防车类型管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TruckType truckType)
    {
        return toAjax(truckTypeService.updateTruckType(truckType));
    }

    /**
     * 删除消防车类型管理
     */
    @PreAuthorize("@ss.hasPermi('information:trucktype:remove')")
    @Log(title = "消防车类型管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{typeids}")
    public AjaxResult remove(@PathVariable Long[] typeids)
    {
        return toAjax(truckTypeService.deleteTruckTypeByTypeids(typeids));
    }
}
