package com.ruoyi.web.controller.sendToWeChat;

import com.ruoyi.sendToWeChat.domain.urlData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 *  @author:xy
 * */

@Api("企业微信发消息接口")
@RestController
@RequestMapping("/sendToWeChat/sendToWeChat_Com")
public class sendToWeChat_Com {
    //发送消息的执行方法
    @ApiOperation("发送消息的执行方法")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid", value = "企业微信中用户唯一的id"),
            @ApiImplicitParam(name = "message", value = "消息内容"),
    })
    @GetMapping("/send")
    public void send(String userid,String message) {
        sendMessage_Company swx = new sendMessage_Company();
        try {
            String token = swx.getToken("ww458c265dc1041b22", "ALp8SU_MFveuWUjicU4BQxKKsf7q0wO7812f5jnmHxg");
            String postdata = swx.createpostdata(userid, "text", 1000002, "content", message);
            String resp = swx.post("utf-8", sendMessage_Company.CONTENT_TYPE, (new urlData()).getSendMessage_Url(), postdata, token);
            System.out.println("获取到的token======>" + token);
            System.out.println("请求数据======>" + postdata);
            System.out.println("发送微信的响应数据======>" + resp);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

}
