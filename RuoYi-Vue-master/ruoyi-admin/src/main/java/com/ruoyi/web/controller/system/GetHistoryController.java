package com.ruoyi.web.controller.system;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysMenu;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginBody;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.framework.web.service.SysLoginService;
import com.ruoyi.framework.web.service.SysPermissionService;
import com.ruoyi.system.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * 登录验证
 * 
 * @author ruoyi
 */
@RestController
public class GetHistoryController
{

    @GetMapping("/getHistory")
    public AjaxResult getHistory()
    {
        List informList = new ArrayList<>();
        List informs = new ArrayList();
        HashMap inform = new HashMap();
        inform.put("sendtime", "2011-10-21T00:00:00.000+0800");
        inform.put("location", "SHU");
        inform.put("disastertype", "火灾");
        List<String> text = new ArrayList<String>();
        text.add("严格落实一线指挥。指挥员要靠前指挥。");
        inform.put("text1", text);
        informList.add(inform);
        AjaxResult ajax = AjaxResult.success();
        System.out.println(informList);
        ajax.put("rows", informList);
        ajax.put("total", 2);
        ajax.put("msg", "查询成功");
        return ajax;
    }
}
