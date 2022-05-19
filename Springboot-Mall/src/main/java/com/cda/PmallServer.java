package com.cda;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author cda
 */
@EnableAsync
@SpringBootApplication
@MapperScan("com.cda.dao")
public class PmallServer {
    public static void main(String[] args) {
        SpringApplication.run(PmallServer.class,args);
    }
}
