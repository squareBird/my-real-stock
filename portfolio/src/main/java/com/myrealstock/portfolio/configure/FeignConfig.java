package com.myrealstock.portfolio.configure;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    Logger.Level githubFeignClientLoggerLevel() {
        return Logger.Level.FULL;
    }

}
