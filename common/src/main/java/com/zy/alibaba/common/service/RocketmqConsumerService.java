package com.zy.alibaba.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

/**
 * @AUTHOR zhangy
 * 2020-06-09  21:59
 */
@Service
public class RocketmqConsumerService {

    private Logger logger = LoggerFactory.getLogger(RocketmqConsumerService.class);

    @StreamListener(Sink.INPUT)
    public void inputConsumer(String message) {
        logger.info("从Binding-{}收到信息-{}", Sink.INPUT, message);
    }
}
