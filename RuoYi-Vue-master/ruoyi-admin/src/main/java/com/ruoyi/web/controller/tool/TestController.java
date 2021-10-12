package com.ruoyi.web.controller.tool;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

/**
 * swagger 用户测试方法
 *
 * @author ruoyi
 */
@Api("用户信息管理")
@RestController
@RequestMapping("/test/user")
public class TestController extends BaseController
{
    private final static Map<Integer, UserEntity> users = new LinkedHashMap<Integer, UserEntity>();
    {
        users.put(1, new UserEntity(1, 2, 10));
        users.put(2, new UserEntity(2, 2, 10));
    }

//    @ApiOperation("获取匹配规则")
//    @GetMapping("/list")
//    public AjaxResult userList()
//    {
//        List<UserEntity> userList = new ArrayList<UserEntity>(users.values());
//        return AjaxResult.success(userList);
//    }

    @ApiOperation("获取规则信息")
    @ApiImplicitParams({
            @ApiImplicitParam( name="PositonId",value="岗位ID",required = true,dataType = "Integer",paramType="query"),
            @ApiImplicitParam( name="InformTypeId",value="信息类型ID",required = true,dataType = "Integer",paramType="query"),
            @ApiImplicitParam( name="num",value="数量",required = true,dataType = "Integer",paramType="query"),
    })
    @PostMapping("/save2")
    public AjaxResult save2(UserEntity user)
    {
        if (StringUtils.isNull(user) || StringUtils.isNull(user.getPositionId()))
        {
            return error("用户ID不能为空");
        }
        return AjaxResult.success(users.put(user.getPositionId(), user));
    }

    @ApiOperation("获取发送状态")
    @ApiImplicitParam(name = "SendStatus", value = "发送状态", required = true, dataType = "Integer", paramType = "path")
    @GetMapping("/{SendStatus}")
    public AjaxResult getStatus(@PathVariable Integer SendStatus)
    {
        if (!users.isEmpty() && users.containsKey(SendStatus))
        {
            return AjaxResult.success(users.get(SendStatus));
        }
        else
        {
            return error("用户不存在");
        }
    }

    @ApiOperation("匹配信息")
    @ApiImplicitParams({
            @ApiImplicitParam( name="DisasterType",value="类别",required = true,dataType = "Integer",paramType="query"),
            @ApiImplicitParam( name="DisposeObject",value="处置对象",required = true,dataType = "Integer",paramType="query"),
            @ApiImplicitParam( name="DetailType",value="险情类型",required = true,dataType = "Integer",paramType="query"),
            @ApiImplicitParam( name="Label4",value="附加标签",required = true,dataType = "Integer",paramType="query"),
            @ApiImplicitParam( name="KeyWord",value="关键词",required = true,dataType = "String",paramType="query")
    })
    @PostMapping("/save1")
    public AjaxResult save1(UserEntity user)
    {
        if (StringUtils.isNull(user) || StringUtils.isNull(user.getPositionId()))
        {
            return error("用户ID不能为空");
        }
        return AjaxResult.success(users.put(user.getPositionId(), user));
    }
}

@ApiModel(value = "UserEntity", description = "规则实体")
class UserEntity
{
    @ApiModelProperty("岗位ID")
    private Integer PositionId;

    @ApiModelProperty("信息类型ID")
    private Integer InformTypeId;

    @ApiModelProperty("数量")
    private Integer num;



    public UserEntity(Integer PositionId, Integer InformTypeId, Integer num)
    {
        this.PositionId = PositionId;
        this.InformTypeId = InformTypeId;
        this.num = num;

    }

    public Integer getPositionId()
    {
        return PositionId;
    }

    public void setPositionId(Integer PositionId)
    {
        this.PositionId = PositionId;
    }

    public Integer getInformTypeId()
    {
        return InformTypeId;
    }

    public void setInformTypeId(Integer InformTypeId)
    {
        this.InformTypeId = InformTypeId;
    }

    public Integer getnum()
    {
        return num;
    }

    public void setnum(Integer num)
    {
        this.num = num;
    }


}
