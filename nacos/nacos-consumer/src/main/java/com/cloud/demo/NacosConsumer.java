package com.cloud.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@EnableDiscoveryClient
@RestController
@SpringBootApplication
public class NacosConsumer {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumer.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    /* 无法直接访问http://nacos-provider/test，但RestTemplate可以 */
    @RequestMapping("/test")
    public String test() {
        return restTemplate.getForObject("http://nacos-provider/test", String.class);
    }

    @Autowired
    private ClientService clientService;

    @RequestMapping("/test2")
    public String test2() {
        return clientService.test();
    }

}
