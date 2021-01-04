package com.hsy.serviceconsumer.controller;

import com.hsy.serviceconsumer.component.HelloServiceCommand;
import com.hsy.serviceconsumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;

@RestController
public class HelloControler {

    @Autowired
    HelloService helloService;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name) throws ExecutionException, InterruptedException{
        return helloService.hiService(name);
    }

    @RequestMapping("/consumer")
    public String helloConsumer(@RequestParam String name) throws ExecutionException, InterruptedException {

        HelloServiceCommand command = new HelloServiceCommand("hello",restTemplate,name);
        String result = command.execute();
        return result;
    }
}
