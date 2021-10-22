package com.ruoyi.web.controller.information;

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
import com.ruoyi.information.domain.TruckInform;
import com.ruoyi.information.service.ITruckInformService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 消防车信息管理Controller
 * 
 * @author Mathripper
 * @date 2021-10-20
 */
@RestController
@RequestMapping("/information/truckinform")
public class TruckInformController extends BaseController
{
    @Autowired
    private ITruckInformService truckInformService;

    /**
     * 查询消防车信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('information:truckinform:list')")
    @GetMapping("/list")
    public TableDataInfo list(TruckInform truckInform)
    {
        startPage();
        List<TruckInform> list = truckInformService.selectTruckInformList(truckInform);
        return getDataTable(list);
    }

    /**
     * 导出消防车信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('information:truckinform:export')")
    @Log(title = "消防车信息管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TruckInform truckInform)
    {
        List<TruckInform> list = truckInformService.selectTruckInformList(truckInform);
        ExcelUtil<TruckInform> util = new ExcelUtil<TruckInform>(TruckInform.class);
        return util.exportExcel(list, "消防车信息管理数据");
    }

    /**
     * 获取消防车信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('information:truckinform:query')")
    @GetMapping(value = "/{license}")
    public AjaxResult getInfo(@PathVariable("license") String license)
    {
        return AjaxResult.success(truckInformService.selectTruckInformByLicense(license));
    }

    /**
     * 新增消防车信息管理
     */
    @PreAuthorize("@ss.hasPermi('information:truckinform:add')")
    @Log(title = "消防车信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TruckInform truckInform)
    {
        return toAjax(truckInformService.insertTruckInform(truckInform));
    }

    /**
     * 修改消防车信息管理
     */
    @PreAuthorize("@ss.hasPermi('information:truckinform:edit')")
    @Log(title = "消防车信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TruckInform truckInform)
    {
        return toAjax(truckInformService.updateTruckInform(truckInform));
    }

    /**
     * 删除消防车信息管理
     */
    @PreAuthorize("@ss.hasPermi('information:truckinform:remove')")
    @Log(title = "消防车信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{licenses}")
    public AjaxResult remove(@PathVariable String[] licenses)
    {
        return toAjax(truckInformService.deleteTruckInformByLicenses(licenses));
    }
}
