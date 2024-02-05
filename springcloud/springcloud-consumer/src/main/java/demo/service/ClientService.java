package demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * ①Feign会为所有@FeignClient注解接口创建JDK Proxy代理实例
 * ②由FeignInvocationHandler.invoke执行真正的远程调用
 * */
//@FeignClient("springcloud-provider")
@FeignClient(name = "provider", url = "http://127.0.0.1:81")
public interface ClientService {

    @RequestMapping(value = "/test")
    String test();

}
