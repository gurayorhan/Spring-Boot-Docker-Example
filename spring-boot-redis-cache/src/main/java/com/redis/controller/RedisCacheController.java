package com.redis.controller;

import com.redis.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisCacheController {

    @Autowired
    private CacheService cacheService;

    private int time = 0;

    @GetMapping("/Get")
    public String cacheController() throws InterruptedException{
        if(time == 5){
            time = 0;
            cacheService.clearCache();
        }
        time++;
        return cacheService.longRunningMethod();
    }

}
