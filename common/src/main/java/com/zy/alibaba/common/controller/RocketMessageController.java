package com.zy.alibaba.common.controller;

import com.zy.alibaba.common.config.rocketmq.StreamClient;
import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @AUTHOR zhangy
 * 2020-06-09  22:11
 */
@RestController
@RequestMapping("/api/rocketmq")
public class RocketMessageController {


    @Autowired
    private Source source;

    @Autowired
    private StreamClient client;



    @RequestMapping("/send1")
    public String sendOutput(@RequestParam("msg") String msg)  {
        this.source.output().send(MessageBuilder.withPayload(msg).build());
        return "status ";
    }

    @RequestMapping("/send2")
    public String sendOutput2() {
         client.output1().send(MessageBuilder.withPayload("Hello RocketMQ Consumer input2").build());
        return "status ";
    }
}
