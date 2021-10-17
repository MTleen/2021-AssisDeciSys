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
import com.ruoyi.knowledge.domain.InformType;
import com.ruoyi.knowledge.service.IInformTypeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 提示信息类型表Controller
 * 
 * @author xiaoyu
 * @date 2021-10-15
 */
@RestController
@RequestMapping("/knowledge/informtype")
public class InformTypeController extends BaseController
{
    @Autowired
    private IInformTypeService informTypeService;

    /**
     * 查询提示信息类型表列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:informtype:list')")
    @GetMapping("/list")
    public TableDataInfo list(InformType informType)
    {
        startPage();
        List<InformType> list = informTypeService.selectInformTypeList(informType);
        return getDataTable(list);
    }

    /**
     * 导出提示信息类型表列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:informtype:export')")
    @Log(title = "提示信息类型表", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(InformType informType)
    {
        List<InformType> list = informTypeService.selectInformTypeList(informType);
        ExcelUtil<InformType> util = new ExcelUtil<InformType>(InformType.class);
        return util.exportExcel(list, "提示信息类型表数据");
    }

    /**
     * 获取提示信息类型表详细信息
     */
    @PreAuthorize("@ss.hasPermi('knowledge:informtype:query')")
    @GetMapping(value = "/{typeid}")
    public AjaxResult getInfo(@PathVariable("typeid") Long typeid)
    {
        return AjaxResult.success(informTypeService.selectInformTypeByTypeid(typeid));
    }

    /**
     * 新增提示信息类型表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:informtype:add')")
    @Log(title = "提示信息类型表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody InformType informType)
    {
        return toAjax(informTypeService.insertInformType(informType));
    }

    /**
     * 修改提示信息类型表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:informtype:edit')")
    @Log(title = "提示信息类型表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody InformType informType)
    {
        return toAjax(informTypeService.updateInformType(informType));
    }

    /**
     * 删除提示信息类型表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:informtype:remove')")
    @Log(title = "提示信息类型表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{typeids}")
    public AjaxResult remove(@PathVariable Long[] typeids)
    {
        return toAjax(informTypeService.deleteInformTypeByTypeids(typeids));
    }
}
