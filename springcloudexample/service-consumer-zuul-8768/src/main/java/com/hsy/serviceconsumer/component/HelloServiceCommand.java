package com.hsy.serviceconsumer.component;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

public class HelloServiceCommand extends HystrixCommand<String> {

    private RestTemplate restTemplate;

    private String name;

    public HelloServiceCommand(String commandGroupKey,RestTemplate restTemplate,String name) {
        super(HystrixCommandGroupKey.Factory.asKey(commandGroupKey));
        this.restTemplate = restTemplate;
        this.name = name;
    }

    //服务调用
    @Override
    protected String run() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return restTemplate.getForEntity("http://SERVICE-HYSTRIX/hi?name="+name,String.class).getBody();
    }

    //服务降级时所调用的Fallback()
    @Override
    protected String getFallback() {
        return name+"error";
    }
}
