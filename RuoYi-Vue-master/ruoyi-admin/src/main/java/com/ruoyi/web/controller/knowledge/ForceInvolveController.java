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
import com.ruoyi.knowledge.domain.ForceInvolve;
import com.ruoyi.knowledge.service.IForceInvolveService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 参战力量Controller
 * 
 * @author Mathripper
 * @date 2021-12-08
 */
@RestController
@RequestMapping("/knowledge/forceinvolve")
public class ForceInvolveController extends BaseController
{
    @Autowired
    private IForceInvolveService forceInvolveService;

    /**
     * 查询参战力量列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:forceinvolve:list')")
    @GetMapping("/list")
    public TableDataInfo list(ForceInvolve forceInvolve)
    {
        startPage();
        List<ForceInvolve> list = forceInvolveService.selectForceInvolveList(forceInvolve);
        return getDataTable(list);
    }

    /**
     * 导出参战力量列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:forceinvolve:export')")
    @Log(title = "参战力量", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ForceInvolve forceInvolve)
    {
        List<ForceInvolve> list = forceInvolveService.selectForceInvolveList(forceInvolve);
        ExcelUtil<ForceInvolve> util = new ExcelUtil<ForceInvolve>(ForceInvolve.class);
        return util.exportExcel(list, "参战力量数据");
    }

    /**
     * 获取参战力量详细信息
     */
    @PreAuthorize("@ss.hasPermi('knowledge:forceinvolve:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(forceInvolveService.selectForceInvolveById(id));
    }

    /**
     * 新增参战力量
     */
    @PreAuthorize("@ss.hasPermi('knowledge:forceinvolve:add')")
    @Log(title = "参战力量", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ForceInvolve forceInvolve)
    {
        return toAjax(forceInvolveService.insertForceInvolve(forceInvolve));
    }

    /**
     * 修改参战力量
     */
    @PreAuthorize("@ss.hasPermi('knowledge:forceinvolve:edit')")
    @Log(title = "参战力量", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ForceInvolve forceInvolve)
    {
        return toAjax(forceInvolveService.updateForceInvolve(forceInvolve));
    }

    /**
     * 删除参战力量
     */
    @PreAuthorize("@ss.hasPermi('knowledge:forceinvolve:remove')")
    @Log(title = "参战力量", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(forceInvolveService.deleteForceInvolveByIds(ids));
    }
}
