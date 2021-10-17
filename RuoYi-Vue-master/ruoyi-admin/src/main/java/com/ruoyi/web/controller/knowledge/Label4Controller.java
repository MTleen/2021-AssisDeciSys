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
import com.ruoyi.knowledge.domain.Label4;
import com.ruoyi.knowledge.service.ILabel4Service;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 四级标签Controller
 * 
 * @author xiaoyu
 * @date 2021-10-15
 */
@RestController
@RequestMapping("/knowledge/label4")
public class Label4Controller extends BaseController
{
    @Autowired
    private ILabel4Service label4Service;

    /**
     * 查询四级标签列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:label4:list')")
    @GetMapping("/list")
    public TableDataInfo list(Label4 label4)
    {
        startPage();
        List<Label4> list = label4Service.selectLabel4List(label4);
        return getDataTable(list);
    }

    /**
     * 导出四级标签列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:label4:export')")
    @Log(title = "四级标签", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Label4 label4)
    {
        List<Label4> list = label4Service.selectLabel4List(label4);
        ExcelUtil<Label4> util = new ExcelUtil<Label4>(Label4.class);
        return util.exportExcel(list, "四级标签数据");
    }

    /**
     * 获取四级标签详细信息
     */
    @PreAuthorize("@ss.hasPermi('knowledge:label4:query')")
    @GetMapping(value = "/{labelid}")
    public AjaxResult getInfo(@PathVariable("labelid") Long labelid)
    {
        return AjaxResult.success(label4Service.selectLabel4ByLabelid(labelid));
    }

    /**
     * 新增四级标签
     */
    @PreAuthorize("@ss.hasPermi('knowledge:label4:add')")
    @Log(title = "四级标签", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Label4 label4)
    {
        return toAjax(label4Service.insertLabel4(label4));
    }

    /**
     * 修改四级标签
     */
    @PreAuthorize("@ss.hasPermi('knowledge:label4:edit')")
    @Log(title = "四级标签", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Label4 label4)
    {
        return toAjax(label4Service.updateLabel4(label4));
    }

    /**
     * 删除四级标签
     */
    @PreAuthorize("@ss.hasPermi('knowledge:label4:remove')")
    @Log(title = "四级标签", businessType = BusinessType.DELETE)
	@DeleteMapping("/{labelids}")
    public AjaxResult remove(@PathVariable Long[] labelids)
    {
        return toAjax(label4Service.deleteLabel4ByLabelids(labelids));
    }
}
