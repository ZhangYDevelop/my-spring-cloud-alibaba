package com.zy.alibaba.common.config.rocketmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamClient {

    @Input("input1")
    SubscribableChannel input1();

    @Output("output1")
    MessageChannel output1();
}
