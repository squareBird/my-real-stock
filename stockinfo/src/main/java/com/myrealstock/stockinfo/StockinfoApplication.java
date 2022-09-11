package com.myrealstock.stockinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StockinfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockinfoApplication.class, args);
    }

}
