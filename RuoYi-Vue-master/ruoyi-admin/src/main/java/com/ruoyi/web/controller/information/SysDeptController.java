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
import com.ruoyi.information.domain.SysDept;
import com.ruoyi.information.service.ISysDeptService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 队站信息管理Controller
 * 
 * @author Mathripper
 * @date 2021-10-20
 */
@RestController
@RequestMapping("/information/dept")
public class SysDeptController extends BaseController
{
    @Autowired
    private ISysDeptService sysDeptService;

    /**
     * 查询队站信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('information:dept:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysDept sysDept)
    {
        startPage();
        List<SysDept> list = sysDeptService.selectSysDeptList(sysDept);
        return getDataTable(list);
    }

    /**
     * 导出队站信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('information:dept:export')")
    @Log(title = "队站信息管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysDept sysDept)
    {
        List<SysDept> list = sysDeptService.selectSysDeptList(sysDept);
        ExcelUtil<SysDept> util = new ExcelUtil<SysDept>(SysDept.class);
        return util.exportExcel(list, "队站信息管理数据");
    }

    /**
     * 获取队站信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('information:dept:query')")
    @GetMapping(value = "/{deptId}")
    public AjaxResult getInfo(@PathVariable("deptId") Long deptId)
    {
        return AjaxResult.success(sysDeptService.selectSysDeptByDeptId(deptId));
    }

    /**
     * 新增队站信息管理
     */
    @PreAuthorize("@ss.hasPermi('information:dept:add')")
    @Log(title = "队站信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysDept sysDept)
    {
        return toAjax(sysDeptService.insertSysDept(sysDept));
    }

    /**
     * 修改队站信息管理
     */
    @PreAuthorize("@ss.hasPermi('information:dept:edit')")
    @Log(title = "队站信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysDept sysDept)
    {
        return toAjax(sysDeptService.updateSysDept(sysDept));
    }

    /**
     * 删除队站信息管理
     */
    @PreAuthorize("@ss.hasPermi('information:dept:remove')")
    @Log(title = "队站信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deptIds}")
    public AjaxResult remove(@PathVariable Long[] deptIds)
    {
        return toAjax(sysDeptService.deleteSysDeptByDeptIds(deptIds));
    }
}
