package com.acec.feignconsumer;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("hello-service")
public interface HelloService {

    @RequestMapping("/hello")
    String hello();

    @RequestMapping("/getUser")
    User getMyUser();


    @RequestMapping("/getUser1")
    User getMyUser(@RequestParam("id") Long id);
}
