package com.countime.bootlearn.HelloWordController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @RequestMapping("/")
    public String hello() {
        return "hello world";
    }


    @Value("${test.key1}")
    private String testKey1;
    @Value("${test.key2}")
    private String testKey2;

    @RequestMapping("/profiletest")
    public String profiletest() {
        return "key1:" + testKey1 + "</br>" +
                "key2:" + testKey2;
    }
}
