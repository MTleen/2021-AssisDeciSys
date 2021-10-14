package com.ruoyi.web.controller.knowledge;

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
import com.ruoyi.knowledge.domain.DisasterType;
import com.ruoyi.knowledge.service.IDisasterTypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 险情类型Controller
 * 
 * @author Mathripper
 * @date 2021-10-14
 */
@RestController
@RequestMapping("/knowledge/disastertype")
public class DisasterTypeController extends BaseController
{
    @Autowired
    private IDisasterTypeService disasterTypeService;

    /**
     * 查询险情类型列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:disastertype:list')")
    @GetMapping("/list")
    public TableDataInfo list(DisasterType disasterType)
    {
        startPage();
        List<DisasterType> list = disasterTypeService.selectDisasterTypeList(disasterType);
        return getDataTable(list);
    }

    /**
     * 导出险情类型列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:disastertype:export')")
    @Log(title = "险情类型", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DisasterType disasterType)
    {
        List<DisasterType> list = disasterTypeService.selectDisasterTypeList(disasterType);
        ExcelUtil<DisasterType> util = new ExcelUtil<DisasterType>(DisasterType.class);
        return util.exportExcel(list, "险情类型数据");
    }

    /**
     * 获取险情类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('knowledge:disastertype:query')")
    @GetMapping(value = "/{typeid}")
    public AjaxResult getInfo(@PathVariable("typeid") Long typeid)
    {
        return AjaxResult.success(disasterTypeService.selectDisasterTypeByTypeid(typeid));
    }

    /**
     * 新增险情类型
     */
    @PreAuthorize("@ss.hasPermi('knowledge:disastertype:add')")
    @Log(title = "险情类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DisasterType disasterType)
    {
        return toAjax(disasterTypeService.insertDisasterType(disasterType));
    }

    /**
     * 修改险情类型
     */
    @PreAuthorize("@ss.hasPermi('knowledge:disastertype:edit')")
    @Log(title = "险情类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DisasterType disasterType)
    {
        return toAjax(disasterTypeService.updateDisasterType(disasterType));
    }

    /**
     * 删除险情类型
     */
    @PreAuthorize("@ss.hasPermi('knowledge:disastertype:remove')")
    @Log(title = "险情类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{typeids}")
    public AjaxResult remove(@PathVariable Long[] typeids)
    {
        return toAjax(disasterTypeService.deleteDisasterTypeByTypeids(typeids));
    }
}
