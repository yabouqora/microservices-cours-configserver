package com.example.aurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AurekaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AurekaServiceApplication.class, args);
    }

}
