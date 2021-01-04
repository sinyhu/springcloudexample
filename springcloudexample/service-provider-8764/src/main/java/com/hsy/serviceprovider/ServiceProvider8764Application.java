package com.hsy.serviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceProvider8764Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProvider8764Application.class, args);
    }

}
