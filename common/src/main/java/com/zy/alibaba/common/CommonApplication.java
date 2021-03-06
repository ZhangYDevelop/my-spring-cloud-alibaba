package com.zy.alibaba.common;

//import com.zy.alibaba.common.config.rocketmq.StreamClient;
import com.zy.alibaba.common.config.rocketmq.StreamClient;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;


@SpringBootApplication
@EnableDubbo
@EnableBinding({Source.class, Sink.class, StreamClient.class})
@EnableDiscoveryClient
@MapperScan("com.zy.alibaba.common.mapper")
@EnableCaching
public class CommonApplication  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class, args);
    }

    /**
     * 实现了 CommandLineRunner 接口，是为了 Spring Boot 启动时执行任务
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
//       boolean flag =  output.send(MessageBuilder.withPayload("Hello RocketMQ Consumer 23456").build());
////        System.out.println(flag);
    }


}
