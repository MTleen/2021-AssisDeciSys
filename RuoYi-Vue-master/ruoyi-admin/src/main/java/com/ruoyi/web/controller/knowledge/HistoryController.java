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
import com.ruoyi.knowledge.domain.History;
import com.ruoyi.knowledge.service.IHistoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 历史表Controller
 *
 * @author xiaoyu
 * @date 2021-10-29
 */
@RestController
@RequestMapping("/knowledge/history")
public class HistoryController extends BaseController
{
    @Autowired
    private IHistoryService historyService;

    /**
     * 查询历史表列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:history:list')")
    @GetMapping("/list")
    public TableDataInfo list(History history)
    {
        startPage();
        List<History> list = historyService.selectHistoryList(history);
        return getDataTable(list);
    }

    /**
     * 导出历史表列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:history:export')")
    @Log(title = "历史表", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(History history)
    {
        List<History> list = historyService.selectHistoryList(history);
        ExcelUtil<History> util = new ExcelUtil<History>(History.class);
        return util.exportExcel(list, "历史表数据");
    }

    /**
     * 获取历史表详细信息
     */
    @PreAuthorize("@ss.hasPermi('knowledge:history:query')")
    @GetMapping(value = "/{index}")
    public AjaxResult getInfo(@PathVariable("index") Long index)
    {
        return AjaxResult.success(historyService.selectHistoryByIndex(index));
    }

    /**
     * 新增历史表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:history:add')")
    @Log(title = "历史表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody History history)
    {
        return toAjax(historyService.insertHistory(history));
    }

    /**
     * 修改历史表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:history:edit')")
    @Log(title = "历史表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody History history)
    {
        return toAjax(historyService.updateHistory(history));
    }

    /**
     * 删除历史表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:history:remove')")
    @Log(title = "历史表", businessType = BusinessType.DELETE)
    @DeleteMapping("/{indexs}")
    public AjaxResult remove(@PathVariable Long[] indexs)
    {
        return toAjax(historyService.deleteHistoryByIndexs(indexs));
    }
}