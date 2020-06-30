package com.zy.alibaba.common.controller;

import com.zy.alibaba.common.config.rocketmq.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.binder.BinderHeaders;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


/**
 * @AUTHOR zhangy
 * 2020-06-09  22:11
 */
@RestController
@RequestMapping("/api/rocketmq")
@SuppressWarnings("all")
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

    /**
     * 发送顺序消息
     * @return
     */
    @RequestMapping("/send2")
    public String sendOutput2() {
        List<String> list = Arrays.asList("创建订单", "支付", "退款");
        for (String s : list) {
            MessageBuilder builder = MessageBuilder.withPayload(s).setHeader(BinderHeaders.PARTITION_HEADER, 0);
            Message message = builder.build();
//            long time = Long.valueOf("100");
//            try {
//                Thread.currentThread().sleep(time);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            client.smsProvider().send(message);
        }
        return "status " + System.currentTimeMillis();
    }
}
