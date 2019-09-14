package com.fj.eureka.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello，接口请求好了";
    }
}

