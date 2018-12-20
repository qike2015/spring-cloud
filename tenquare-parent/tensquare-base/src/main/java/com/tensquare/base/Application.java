package com.tensquare.base;

import com.qike.tensquare.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application
{

    public static void main(String[] args)
    {
        SpringApplication.run(Application.class);
    }

    @Bean
    public IdWorker idWorker(){
        return  new IdWorker(1,1);
    }

}
