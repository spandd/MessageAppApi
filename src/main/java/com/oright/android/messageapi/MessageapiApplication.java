package com.oright.android.messageapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 这个就是后端
 * spring boot + mybatis + socket
 */

@MapperScan(value = "com.oright.android.messageapi.web.mapper")
@SpringBootApplication
public class MessageapiApplication {
    public static void main(String[] args) {

        SpringApplication.run(MessageapiApplication.class, args);

    }

}
