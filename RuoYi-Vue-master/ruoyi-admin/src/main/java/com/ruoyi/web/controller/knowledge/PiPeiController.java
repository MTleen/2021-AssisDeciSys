package com.ruoyi.web.controller.knowledge;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.knowledge.domain.Record;
import com.ruoyi.knowledge.domain.PiPei;
import com.ruoyi.knowledge.service.IPiPeiService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//public class PiPeiController {
//}



/**
 * 出警记录表Controller
 *
 * @author ruoyi
 * @date 2021-10-15
 */
@RestController
//@RequestMapping("/index")
public class PiPeiController extends BaseController
{
    @Autowired
    private IPiPeiService pipeiService;
    @ApiOperation("匹配提示信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="cautionid",value="出警编号",dataType="String"),
            @ApiImplicitParam(name="cationtime",value="报警时间",dataType="Date"),
            @ApiImplicitParam(name="location",value="地址",dataType="String"),
            @ApiImplicitParam(name="distypeid",value="险情类型",dataType="Integer"),
            @ApiImplicitParam(name="dillobject",value="处置对象",dataType="Integer"),
            @ApiImplicitParam(name="detailtype",value="详细类型",dataType="Integer"),
            @ApiImplicitParam(name="label4",value="四级标签",dataType="Integer"),
            @ApiImplicitParam(name="keywords",value="关键字",dataType="String"),
            @ApiImplicitParam(name="siteid",value="主管单位",dataType="Integer"),
            @ApiImplicitParam(name="truckid",value="出警车辆",dataType="Integer"),
            @ApiImplicitParam(name="supplement",value="提示信息",dataType="String"),
            @ApiImplicitParam(name="picture",value="图片",dataType="String"),
            @ApiImplicitParam(name="status",value="任务执行状态",dataType="Boolean"),

    })

    /**
     * 查询出警记录表列表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:pipei:list')")
    @GetMapping("/pipei")
    public TableDataInfo list(PiPei pipei )
    {
        startPage();
        List<PiPei> list = pipeiService.selectPiPeiList(pipei);
        return getDataTable(list);
    }

    /**
     * 新增出警记录表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:pipei:add')")
    @Log(title = "出警记录表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PiPei pipei)
    {
        return toAjax(pipeiService.insertPiPei(pipei));
    }

    /**
     * 修改出警记录表
     */
    @PreAuthorize("@ss.hasPermi('knowledge:pipei:edit')")
    @Log(title = "出警记录表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PiPei pipei)
    {
        return toAjax(pipeiService.updatePiPei(pipei));
    }


}
