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
import com.ruoyi.knowledge.domain.TypeRelation;
import com.ruoyi.knowledge.service.ITypeRelationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 标签关系Controller
 * 
 * @author Mathripper
 * @date 2021-12-08
 */
@RestController
@RequestMapping("/knowledge/typerelation")
public class TypeRelationController extends BaseController
{
    @Autowired
    private ITypeRelationService typeRelationService;

    /**
     * 查询标签关系列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:typerelation:list')")
    @GetMapping("/list")
    public TableDataInfo list(TypeRelation typeRelation)
    {
        startPage();
        List<TypeRelation> list = typeRelationService.selectTypeRelationList(typeRelation);
        return getDataTable(list);
    }

    /**
     * 导出标签关系列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:typerelation:export')")
    @Log(title = "标签关系", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TypeRelation typeRelation)
    {
        List<TypeRelation> list = typeRelationService.selectTypeRelationList(typeRelation);
        ExcelUtil<TypeRelation> util = new ExcelUtil<TypeRelation>(TypeRelation.class);
        return util.exportExcel(list, "标签关系数据");
    }

    /**
     * 获取标签关系详细信息
     */
    @PreAuthorize("@ss.hasPermi('knowledge:typerelation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(typeRelationService.selectTypeRelationById(id));
    }

    /**
     * 新增标签关系
     */
    @PreAuthorize("@ss.hasPermi('knowledge:typerelation:add')")
    @Log(title = "标签关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TypeRelation typeRelation)
    {
        return toAjax(typeRelationService.insertTypeRelation(typeRelation));
    }

    /**
     * 修改标签关系
     */
    @PreAuthorize("@ss.hasPermi('knowledge:typerelation:edit')")
    @Log(title = "标签关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TypeRelation typeRelation)
    {
        return toAjax(typeRelationService.updateTypeRelation(typeRelation));
    }

    /**
     * 删除标签关系
     */
    @PreAuthorize("@ss.hasPermi('knowledge:typerelation:remove')")
    @Log(title = "标签关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(typeRelationService.deleteTypeRelationByIds(ids));
    }
}
