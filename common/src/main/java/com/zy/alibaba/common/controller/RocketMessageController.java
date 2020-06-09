package com.zy.alibaba.common.Controller;

import com.zy.alibaba.common.config.rocketmq.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @AUTHOR zhangy
 * 2020-06-09  22:11
 */
@RestController
@RequestMapping("/api/rocketmq/")
public class RocketMessageController {


    @Autowired
    private MessageChannel output;

    @Autowired
    private StreamClient client;


    @RequestMapping("/send1")
    public String sendOutput() {
        boolean flag =  output.send(MessageBuilder.withPayload("Hello RocketMQ Consumer input1").build());
        return "status " + flag;
    }

    @RequestMapping("/send2")
    public String sendOutput2() {
        boolean flag =  client.output1().send(MessageBuilder.withPayload("Hello RocketMQ Consumer input2").build());
        return "status " + flag;
    }
}
