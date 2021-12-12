package com.eastmoney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class StockSpiderApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockSpiderApplication.class, args);
    }

}
