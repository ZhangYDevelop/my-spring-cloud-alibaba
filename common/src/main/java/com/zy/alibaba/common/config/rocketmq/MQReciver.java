package com.zy.alibaba.common.config.rocketmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

//@Component
//@EnableBinding(StreamClient.class)
public class MQReciver {

    private Logger logger = LoggerFactory.getLogger(MQReciver.class);

    @StreamListener("input1")
    public void test(String message){
        logger.info(message);
    }
}
