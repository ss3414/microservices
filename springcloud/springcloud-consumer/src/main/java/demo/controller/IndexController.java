package demo.controller;

import demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("")
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ClientService clientService;

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("/index");
    }

    @RequestMapping("/rest")
    public Map<String, Object> rest() {
        Map<String, Object> map = new LinkedHashMap<>();
        /* 不是直接通过HTTP而是通过注册中心访问provider */
        String str = restTemplate.getForObject("http://springcloud-provider/test", String.class);
        map.put("rest", str);
        return map;
    }

    @RequestMapping("/openfeign")
    public Map<String, Object> openfeign() {
        Map<String, Object> map = new LinkedHashMap<>();
        String str = clientService.test();
        map.put("openfeign", str);
        return map;
    }

}
