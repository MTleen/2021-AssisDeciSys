package com.ruoyi.web.controller.sendToWeChat;

import com.google.gson.Gson;
import com.ruoyi.sendToWeChat.domain.AccessToken;
import com.ruoyi.sendToWeChat.domain.TemplateData;
import com.ruoyi.sendToWeChat.domain.WxMssVo;
import com.ruoyi.sendToWeChat.service.WechatService;
//import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


/**
 * author xy
 **/

@RestController
@Slf4j
public class sendMessage {
    /**
     * 发送订阅消息
     */

    @GetMapping("/push")
    public String push(String openid, Map<String, TemplateData> m, String s) { //,List<String> text
        WechatService wechatService = new WechatService();
        RestTemplate restTemplate = new RestTemplate();
        String baseurl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={APPID}&secret={APPSECRET}";
        Map<String, String> params = new HashMap<>();
        params.put("APPID", "wxa6d7ea2aee741840");
        params.put("APPSECRET", "7d466b43bbb24dfa1d496628a28aaeef");
        //这里简单起见我们每次都获取最新的access_token（实际开发中，应该在access_token快过期时再重新获取）
        String url = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token=" + wechatService.getAccessToken(baseurl, params);
        //拼接推送的模版
        WxMssVo wxMssVo = new WxMssVo();
        wxMssVo.setTouser(openid);//用户的openid（要发送给那个用户，通常这里应该动态传进来的）
        wxMssVo.setTemplate_id("IZ2f3IdGTHd-G0gS6nMWqdpMkXl5hA5SRL3wxHJ1xbE");//订阅消息模板id
        wxMssVo.setData(m);
        wxMssVo.setPage(s);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, wxMssVo, String.class);
        System.out.println("MSG：" + responseEntity.getBody());
        return responseEntity.getBody();
    }

    /**
     * 获取AccessToken
     */
//    @GetMapping("/getAccessToken")
//    public String getAccessToken(String baseurl, Map<String, String> params) {
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
//                baseurl, String.class, params);
//        String body = responseEntity.getBody();
//        AccessToken object = new Gson().fromJson(body, AccessToken.class);
////        log.info("返回的AccessToken={}",object);
//        String Access_Token = object.getAccess_token();
//        return Access_Token;
//    }
}

