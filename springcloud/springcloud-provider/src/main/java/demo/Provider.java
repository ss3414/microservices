package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@EnableEurekaServer
@SpringBootApplication
public class Provider {

    public static void main(String[] args) {
        SpringApplication.run(Provider.class, args);
    }

    @RequestMapping("/")
    public Map<String, Object> index() {
        return new LinkedHashMap<>();
    }

    @RequestMapping("/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("test", HttpStatus.OK);
    }

}
