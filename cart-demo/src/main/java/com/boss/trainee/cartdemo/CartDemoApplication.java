package com.boss.trainee.cartdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.boss.trainee.cartdemo.dao")
public class CartDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CartDemoApplication.class, args);
    }

}
