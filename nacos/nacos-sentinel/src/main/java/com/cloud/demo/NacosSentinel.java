package com.cloud.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients
@RestController
@SpringBootApplication
public class NacosSentinel {

    public static void main(String[] args) {
        SpringApplication.run(NacosSentinel.class, args);
    }

    @Autowired
    private ClientService clientService;

    @RequestMapping("/test")
    public String test() {
        return clientService.test();
    }

}
