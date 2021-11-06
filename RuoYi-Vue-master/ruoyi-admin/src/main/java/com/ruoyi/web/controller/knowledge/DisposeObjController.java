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
import com.ruoyi.knowledge.domain.DisposeObj;
import com.ruoyi.knowledge.service.IDisposeObjService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 处置对象Controller
 *
 * @author Mathripper
 * @date 2021-11-05
 */
@RestController
@RequestMapping("/knowledge/disposeobj")
public class DisposeObjController extends BaseController
{
    @Autowired
    private IDisposeObjService disposeObjService;

    /**
     * 查询处置对象列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:disposeobj:list')")
    @GetMapping("/list")
    public TableDataInfo list(DisposeObj disposeObj)
    {
        startPage();
        List<DisposeObj> list = disposeObjService.selectDisposeObjList(disposeObj);
        return getDataTable(list);
    }

    /**
     * 导出处置对象列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:disposeobj:export')")
    @Log(title = "处置对象", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(DisposeObj disposeObj)
    {
        List<DisposeObj> list = disposeObjService.selectDisposeObjList(disposeObj);
        ExcelUtil<DisposeObj> util = new ExcelUtil<DisposeObj>(DisposeObj.class);
        return util.exportExcel(list, "处置对象数据");
    }

    /**
     * 获取处置对象详细信息
     */
    @PreAuthorize("@ss.hasPermi('knowledge:disposeobj:query')")
    @GetMapping(value = "/{objid}")
    public AjaxResult getInfo(@PathVariable("objid") Long objid)
    {
        return AjaxResult.success(disposeObjService.selectDisposeObjByObjid(objid));
    }

    /**
     * 新增处置对象
     */
    @PreAuthorize("@ss.hasPermi('knowledge:disposeobj:add')")
    @Log(title = "处置对象", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DisposeObj disposeObj)
    {
        return toAjax(disposeObjService.insertDisposeObj(disposeObj));
    }

    /**
     * 修改处置对象
     */
    @PreAuthorize("@ss.hasPermi('knowledge:disposeobj:edit')")
    @Log(title = "处置对象", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DisposeObj disposeObj)
    {
        return toAjax(disposeObjService.updateDisposeObj(disposeObj));
    }

    /**
     * 删除处置对象
     */
    @PreAuthorize("@ss.hasPermi('knowledge:disposeobj:remove')")
    @Log(title = "处置对象", businessType = BusinessType.DELETE)
    @DeleteMapping("/{objids}")
    public AjaxResult remove(@PathVariable Long[] objids)
    {
        return toAjax(disposeObjService.deleteDisposeObjByObjids(objids));
    }
}