package com.tensquare.spit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * @author 豆丁
 * @since 2019/1/11
 */
@SpringBootApplication
public class SpitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpitApplication.class);
    }

    @Bean
    public IdWorker idWorker(){
        return  new IdWorker();
    }
}
