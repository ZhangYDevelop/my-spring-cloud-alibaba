package com.zy.alibaba.common.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zy.alibaba.dubbo.api.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
@SuppressWarnings("all")
public class RedisOptsService {

      @Autowired
    private RedisTemplate<String, String > redisTemplate;

    public void optsForSetString() {
        redisTemplate.opsForValue().set("zhangyu", "张宇");
    }

    public String optsForGetString() {
       String  value = redisTemplate.opsForValue().get("zhangyu");
       return  value;
    }

    public void optsForSetHash() {
        SysUser user = new SysUser();
        user.setId(Long.valueOf(1));
        user.setEnable(true);
        user.setPassword("dsfsdfds");
        user.setRoles("role-admin");
        user.setUsername("zhangsan");

        redisTemplate.opsForHash().put("hashkey-1", "hashkey-1-1" ,JSONObject.toJSONString(user));
    }

    public SysUser optsForGetHash() {
        Object value = redisTemplate.opsForHash().get("hashkey-1", "hashkey-1-1");
        SysUser sysUser = JSONObject.toJavaObject(JSON.parseObject(String.valueOf(value)), SysUser.class);
        return sysUser;
    }

    public void optsForSetList() {
        redisTemplate.opsForList().leftPushAll("list-user-key", "1212","dfd","dfdff");
        SysUser user = new SysUser();
        user.setId(Long.valueOf(1));
        user.setEnable(true);
        user.setPassword("dsfsdfds");
        user.setRoles("role-admin");
        user.setUsername("zhangsan");
        redisTemplate.opsForList().leftPushAll("list-user-key2", JSONObject.toJSONString(user),"dfd","dfdff");
    }

    public String optsForGetList() {
        String value = redisTemplate.opsForList().index("list-user-key2", 0);
        return value;
    }

    public void optsForSet() {
        for (int i = 0; i < 8; i++) {
            SysUser user = new SysUser();
            user.setId(Long.valueOf(1));
            user.setEnable(true);
            user.setPassword("passwd" + i+1);
            user.setRoles("role-admin");
            user.setUsername("user" + i);
            redisTemplate.opsForSet().add("set-key", JSONObject.toJSONString(user));
        }
    }

    public List<SysUser> optsForGetSet() {
       Set<String> list =  redisTemplate.opsForSet().members("set-key");
       Iterator<String> list2 = list.iterator();
       List<SysUser> retList = new ArrayList<>();
       while(list2.hasNext()) {
           String s = list2.next();
           SysUser user = JSONObject.toJavaObject(JSON.parseObject(s), SysUser.class);
           retList.add(user);
       }
       return retList;
    }

    public List<SysUser> optsForZSet() {
//        for (int i = 0; i < 8; i++) {
//            SysUser user = new SysUser();
//            user.setId(Long.valueOf(1));
//            user.setEnable(true);
//            user.setPassword("passwd" + i+1);
//            user.setRoles("role-admin");
//            user.setUsername("user" + i);
//            redisTemplate.opsForZSet().add("zset-key-2", JSONObject.toJSONString(user), i);
//        }

        Set<String> setTmp = redisTemplate.opsForZSet().reverseRange("zset-key-2", 0, 9);
        List<SysUser> retList = new ArrayList<>();
        setTmp.forEach(item -> {
            SysUser user = JSONObject.toJavaObject(JSON.parseObject(item), SysUser.class);
            retList.add(user);

        });
        return retList;
    }
}
