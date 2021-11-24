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
import com.ruoyi.information.domain.Site;
import com.ruoyi.information.service.ISiteService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 队站信息Controller
 * 
 * @author  Mathripper
 * @date 2021-11-16
 */
@RestController
@RequestMapping("/information/site")
public class SiteController extends BaseController
{
    @Autowired
    private ISiteService siteService;

    /**
     * 查询队站信息列表
     */
    @PreAuthorize("@ss.hasPermi('information:site:list')")
    @GetMapping("/list")
    public TableDataInfo list(Site site)
    {
        startPage();
        List<Site> list = siteService.selectSiteList(site);
        return getDataTable(list);
    }

    /**
     * 导出队站信息列表
     */
    @PreAuthorize("@ss.hasPermi('information:site:export')")
    @Log(title = "队站信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Site site)
    {
        List<Site> list = siteService.selectSiteList(site);
        ExcelUtil<Site> util = new ExcelUtil<Site>(Site.class);
        return util.exportExcel(list, "队站信息数据");
    }

    /**
     * 获取队站信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('information:site:query')")
    @GetMapping(value = "/{siteid}")
    public AjaxResult getInfo(@PathVariable("siteid") Long siteid)
    {
        return AjaxResult.success(siteService.selectSiteBySiteid(siteid));
    }

    /**
     * 新增队站信息
     */
    @PreAuthorize("@ss.hasPermi('information:site:add')")
    @Log(title = "队站信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Site site)
    {
        return toAjax(siteService.insertSite(site));
    }

    /**
     * 修改队站信息
     */
    @PreAuthorize("@ss.hasPermi('information:site:edit')")
    @Log(title = "队站信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Site site)
    {
        return toAjax(siteService.updateSite(site));
    }

    /**
     * 删除队站信息
     */
    @PreAuthorize("@ss.hasPermi('information:site:remove')")
    @Log(title = "队站信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{siteids}")
    public AjaxResult remove(@PathVariable Long[] siteids)
    {
        return toAjax(siteService.deleteSiteBySiteids(siteids));
    }
}
