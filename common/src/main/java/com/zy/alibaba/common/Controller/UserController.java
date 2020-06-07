package com.zy.alibaba.common.Controller;

import com.zy.alibaba.common.service.impl.RedisOptsService;
import com.zy.alibaba.dubbo.api.model.SysUser;
import com.zy.alibaba.utils.ResponseBody;
import com.zy.alibaba.utils.security.SecurityUserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private RedisOptsService redisOptsService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/redis/opts")
    public ResponseBody testRedisOpts() {
//        redisOptsService.optsForSetString();
//        String value =  redisOptsService.optsForGetString();
//        redisOptsService.optsForSetHash();
//        SysUser object =  redisOptsService.optsForGetHash();
//        redisOptsService.optsForSetList();
//        String value = redisOptsService.optsForGetList();
//        redisOptsService.optsForSet();
//
//        List<SysUser> list = redisOptsService.optsForGetSet();
        List<SysUser> list = redisOptsService.optsForZSet();
        return new ResponseBody().setSuccess(true).setData(list);
    }

    @PostMapping("/login")
    public ResponseBody login(@RequestParam("username") String username,
                              @RequestParam("password") String  password) {

        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        HttpHeaders httpHeaders = new HttpHeaders();
        param.add("grant_type", "password");
        param.add("scope", "web");
        param.add("username", username);
        param.add("password", password);
        param.add("client_id", "client1");
        param.add("client_secret", "admin");
        HttpMethod httpMethod = HttpMethod.POST;
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity entity = new HttpEntity(param, httpHeaders);
        ResponseEntity responseEntity = restTemplate.exchange("http://localhost:8004/oauth/token", httpMethod,entity, Object.class);
        return ResponseBody.ok(responseEntity.getBody()).setMsg("登录成功");

    }


    @GetMapping("/getUserPrincipal")
    public ResponseBody getUserInfo() {
        return  ResponseBody.ok(SecurityUserHelper.getCurrentAuthentication());
    }

}
