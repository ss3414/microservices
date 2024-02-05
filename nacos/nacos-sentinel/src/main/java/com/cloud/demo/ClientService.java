package com.cloud.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("nacos-provider")
public interface ClientService {

    @RequestMapping(value = "/test")
    String test();

}
