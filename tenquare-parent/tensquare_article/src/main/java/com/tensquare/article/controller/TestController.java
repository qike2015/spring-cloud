package com.tensquare.article.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 豆丁
 * @since 2019/1/21
 */
@RestController
@RequestMapping("/test")
public class TestController {

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping
    public Object test(@RequestParam Map<String,Object> map){

        logger.info("map:{}",map);
        logger.info("name:{}",map.get("name"));

        return map;
    }
}
