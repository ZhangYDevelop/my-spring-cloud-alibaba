package com.zy.alibaba.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @AUTHOR zhangy
 * 2020-06-07  14:23
 */
@Configuration
public class RestemplateConfig {

    @Bean
    public RestTemplate  restTemplate() {
        return  new RestTemplate();
    }
}
