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
import com.ruoyi.knowledge.domain.FeedBack;
import com.ruoyi.knowledge.service.IFeedBackService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 反馈表Controller
 * 
 * @author xiaoyu
 * @date 2021-10-15
 */
@RestController
@RequestMapping("/knowledge/feedback")
public class FeedBackController extends BaseController
{
    @Autowired
    private IFeedBackService feedBackService;

    /**
     * 查询反馈表列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:feedback:list')")
    @GetMapping("/list")
    public TableDataInfo list(FeedBack feedBack)
    {
        startPage();
        List<FeedBack> list = feedBackService.selectFeedBackList(feedBack);
        return getDataTable(list);
    }

    /**
     * 导出反馈表列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:feedback:export')")
    @Log(title = "反馈表", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(FeedBack feedBack)
    {
        List<FeedBack> list = feedBackService.selectFeedBackList(feedBack);
        ExcelUtil<FeedBack> util = new ExcelUtil<FeedBack>(FeedBack.class);
        return util.exportExcel(list, "反馈表数据");
    }

    /**
     * 获取反馈表详细信息
     */
    @PreAuthorize("@ss.hasPermi('knowledge:feedback:query')")
    @GetMapping(value = "/{feedid}")
    public AjaxResult getInfo(@PathVariable("feedid") Long feedid)
    {
        return AjaxResult.success(feedBackService.selectFeedBackByFeedid(feedid));
    }

    /**
     * 新增反馈表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:feedback:add')")
    @Log(title = "反馈表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FeedBack feedBack)
    {
        return toAjax(feedBackService.insertFeedBack(feedBack));
    }

    /**
     * 修改反馈表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:feedback:edit')")
    @Log(title = "反馈表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FeedBack feedBack)
    {
        return toAjax(feedBackService.updateFeedBack(feedBack));
    }

    /**
     * 删除反馈表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:feedback:remove')")
    @Log(title = "反馈表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{feedids}")
    public AjaxResult remove(@PathVariable Long[] feedids)
    {
        return toAjax(feedBackService.deleteFeedBackByFeedids(feedids));
    }
}
