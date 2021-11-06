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
import com.ruoyi.knowledge.domain.DetailType;
import com.ruoyi.knowledge.service.IDetailTypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 详细类型表Controller
 *
 * @author Mathripper
 * @date 2021-11-05
 */
@RestController
@RequestMapping("/knowledge/detailtype")
public class DetailTypeController extends BaseController
{
    @Autowired
    private IDetailTypeService detailTypeService;

    /**
     * 查询详细类型表列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:detailtype:list')")
    @GetMapping("/list")
    public TableDataInfo list(DetailType detailType)
    {
        startPage();
        List<DetailType> list = detailTypeService.selectDetailTypeList(detailType);
        return getDataTable(list);
    }

    /**
     * 导出详细类型表列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:detailtype:export')")
    @Log(title = "详细类型表", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DetailType detailType)
    {
        List<DetailType> list = detailTypeService.selectDetailTypeList(detailType);
        ExcelUtil<DetailType> util = new ExcelUtil<DetailType>(DetailType.class);
        return util.exportExcel(list, "详细类型表数据");
    }

    /**
     * 获取详细类型表详细信息
     */
    @PreAuthorize("@ss.hasPermi('knowledge:detailtype:query')")
    @GetMapping(value = "/{typeid}")
    public AjaxResult getInfo(@PathVariable("typeid") Long typeid)
    {
        return AjaxResult.success(detailTypeService.selectDetailTypeByTypeid(typeid));
    }

    /**
     * 新增详细类型表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:detailtype:add')")
    @Log(title = "详细类型表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DetailType detailType)
    {
        return toAjax(detailTypeService.insertDetailType(detailType));
    }

    /**
     * 修改详细类型表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:detailtype:edit')")
    @Log(title = "详细类型表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DetailType detailType)
    {
        return toAjax(detailTypeService.updateDetailType(detailType));
    }

    /**
     * 删除详细类型表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:detailtype:remove')")
    @Log(title = "详细类型表", businessType = BusinessType.DELETE)
    @DeleteMapping("/{typeids}")
    public AjaxResult remove(@PathVariable Long[] typeids)
    {
        return toAjax(detailTypeService.deleteDetailTypeByTypeids(typeids));
    }
}