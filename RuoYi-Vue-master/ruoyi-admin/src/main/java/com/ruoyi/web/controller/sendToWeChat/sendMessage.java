package com.ruoyi.web.controller.sendToWeChat;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import com.google.gson.Gson;
import com.ruoyi.sendToWeChat.domain.AccessToken;
import com.ruoyi.sendToWeChat.domain.TemplateData;
import com.ruoyi.sendToWeChat.domain.WxMssVo;
//import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * author xy
*
*
**/



@Api("/01")
@RestController
@Slf4j
public class sendMessage {
    // 发送订阅消息
/* * 1.无法单独测试，需要和小程序联动测试
    * 2.还需要写一个调用该方法的类，并把openid写入
    * *//*


*/
    @ApiOperation("/02")
    @GetMapping("/push")
    public String push(String openid) { //,List<String> text
        RestTemplate restTemplate = new RestTemplate();
        //这里简单起见我们每次都获取最新的access_token（实际开发中，应该在access_token快过期时再重新获取）
        String url = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=" + getAccessToken();
        //拼接推送的模版
        WxMssVo wxMssVo = new WxMssVo();
        wxMssVo.setTouser(openid);//用户的openid（要发送给那个用户，通常这里应该动态传进来的）
        wxMssVo.setTemplate_id("IZ2f3IdGTHd-G0gS6nMWqdpMkXl5hA5SRL3wxHJ1xbE");//订阅消息模板id

        //List<Kappinfo> inform = null;

        Map<String, TemplateData> m = new HashMap<>(3);
        m.put("thing1", new TemplateData("XXX暴雨第XXX号应急预案启动"));
        m.put("thing2", new TemplateData("洪涝灾害第01号预案"));
        m.put("thing3", new TemplateData("暴雨造成洪涝灾害，请相关人员立即上岗签到"));
        wxMssVo.setData(m);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, wxMssVo, String.class);
        return responseEntity.getBody();
    }



    @GetMapping("/getAccessToken")
    public String getAccessToken() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<>();
        params.put("APPID", "wxa6d7ea2aee741840");
        params.put("APPSECRET", "7d466b43bbb24dfa1d496628a28aaeef");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
                "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={APPID}&secret={APPSECRET}", String.class, params);
        String body = responseEntity.getBody();
        AccessToken object = new Gson().fromJson(body, AccessToken.class);
//        log.info("返回的AccessToken={}",object);
        String Access_Token = object.getAccess_token();
        Integer expires_in = object.getExpires_in();
        Integer errcode = object.getErrcode();
        String errmsg = object.getErrmsg();
        System.out.println("有效时长expires_in：" + expires_in);
        System.out.println("错误码为"+errcode+"错误信息为"+errmsg);

        return Access_Token;
    }
}

