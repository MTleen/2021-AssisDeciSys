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
import com.ruoyi.knowledge.domain.Record;
import com.ruoyi.knowledge.service.IRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 出警记录表Controller
 *
 * @author Mathripper
 * @date 2021-11-10
 */
@RestController
@RequestMapping("/knowledge/record")
public class RecordController extends BaseController
{
    @Autowired
    private IRecordService recordService;

    /**
     * 查询出警记录表列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(Record record)
    {
        startPage();
        List<Record> list = recordService.selectRecordList(record);
        return getDataTable(list);
    }

    /**
     * 导出出警记录表列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:record:export')")
    @Log(title = "出警记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Record record)
    {
        List<Record> list = recordService.selectRecordList(record);
        ExcelUtil<Record> util = new ExcelUtil<Record>(Record.class);
        return util.exportExcel(list, "出警记录表数据");
    }

    /**
     * 获取出警记录表详细信息
     */
    @PreAuthorize("@ss.hasPermi('knowledge:record:query')")
    @GetMapping(value = "/{cautionid}")
    public AjaxResult getInfo(@PathVariable("cautionid") String cautionid)
    {
        return AjaxResult.success(recordService.selectRecordByCautionid(cautionid));
    }

    /**
     * 新增出警记录表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:record:add')")
    @Log(title = "出警记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Record record)
    {
        return toAjax(recordService.insertRecord(record));
    }

    /**
     * 修改出警记录表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:record:edit')")
    @Log(title = "出警记录表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Record record)
    {
        return toAjax(recordService.updateRecord(record));
    }

    /**
     * 删除出警记录表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:record:remove')")
    @Log(title = "出警记录表", businessType = BusinessType.DELETE)
    @DeleteMapping("/{cautionids}")
    public AjaxResult remove(@PathVariable String[] cautionids)
    {
        return toAjax(recordService.deleteRecordByCautionids(cautionids));
    }
}