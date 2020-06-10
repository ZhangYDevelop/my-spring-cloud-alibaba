package com.zy.alibaba.common.config.rocketmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
public class MQReciver {

    private Logger logger = LoggerFactory.getLogger(MQReciver.class);

    @StreamListener("input1")
    public void test(String message){
        logger.info("从Binding-{}收到信息-{}", "input1", message);
    }

    @StreamListener(Sink.INPUT)
    public void inputConsumer(String message) {
        logger.info("从Binding-{}收到信息-{}", Sink.INPUT, message);
    }
}
