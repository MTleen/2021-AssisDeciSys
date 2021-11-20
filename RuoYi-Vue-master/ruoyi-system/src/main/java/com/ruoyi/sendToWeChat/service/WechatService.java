package com.ruoyi.sendToWeChat.service;

import com.google.gson.Gson;
import com.ruoyi.sendToWeChat.domain.AccessToken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class WechatService {
    @GetMapping("/getAccessToken")
    public String getAccessToken(String baseurl, Map<String, String> params) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
                baseurl, String.class, params);
        String body = responseEntity.getBody();
        AccessToken object = new Gson().fromJson(body, AccessToken.class);
//        log.info("返回的AccessToken={}",object);
        String Access_Token = object.getAccess_token();
        return Access_Token;
    }
}
