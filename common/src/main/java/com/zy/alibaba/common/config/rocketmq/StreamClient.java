package com.zy.alibaba.common.config.rocketmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamClient {

    String smsProvider = "smsProvider";
    String smsConsumer = "smsConsumer";

    @Input(smsConsumer)
    SubscribableChannel smsConsumer();

    @Output(smsProvider)
    MessageChannel smsProvider();
}
