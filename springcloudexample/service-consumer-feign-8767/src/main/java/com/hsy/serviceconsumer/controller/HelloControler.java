package com.hsy.serviceconsumer.controller;

import com.hsy.serviceconsumer.service.HelloService;
import com.hsy.serviceconsumer.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

    @Autowired
    private HelloService helloService;

    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService(name);
    }

    @RequestMapping(value = "/hello")
    public String hello(@RequestParam String name) {
        return userFeignClient.getName(name);
    }

}
