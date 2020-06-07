package com.zy.alibaba.common.Controller;

import com.zy.alibaba.common.service.impl.RedisOptsService;
import com.zy.alibaba.dubbo.api.model.SysUser;
import com.zy.alibaba.utils.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private RedisOptsService redisOptsService;

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
}
