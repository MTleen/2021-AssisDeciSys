package com.ruoyi.web.controller.informsearch;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.informsearch.service.IInformSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * 信息匹配Controller
 *
 * @author Axue
 * @date 2021-10-15
 */
@RestController
@RequestMapping("/informsearch/informsearch")
public class InformSearchController extends BaseController
{
//    @Autowired
//    private IInformSearchService informsearchService;
//
//
//    /**
//     * 获取提示信息表详细信息
//     */
//    @PreAuthorize("@ss.hasPermi('informsearch:informsearch:query')")
//    @GetMapping(value = "/{informid}")
//    public AjaxResult getInfo(@PathVariable("informid") Long informid)
//    {
//        return AjaxResult.success(informsearchService.selectKnowledgeByInformid(informid));
//    }
//    /**
//     * 获取输入参数
//     *
//     * @return 用户信息
//     */
//    @GetMapping("getInfo")
//    public AjaxResult getInfo()
//    {
//        SysUser user = SecurityUtils.getLoginUser().getUser();
//        // 角色集合
//        Set<String> roles = permissionService.getRolePermission(user);
//        // 权限集合
//        Set<String> permissions = permissionService.getMenuPermission(user);
//        AjaxResult ajax = AjaxResult.success();
//        ajax.put("user", user);
//        ajax.put("roles", roles);
//        ajax.put("permissions", permissions);
//        return ajax;
//    }


}


