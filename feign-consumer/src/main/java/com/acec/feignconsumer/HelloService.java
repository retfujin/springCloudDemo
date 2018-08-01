package com.acec.feignconsumer;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "hello-service",fallback = HelloServiceFallback.class)
public interface HelloService {

    @RequestMapping("/hello")
    String hello();



    @RequestMapping(value= "/hello1", method= RequestMethod.GET)
    String hello(@RequestParam("name") String name) ;

    @RequestMapping(value= "/hello2", method= RequestMethod.GET)
    FeignUser hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

    @RequestMapping(value = "/hello3", method= RequestMethod.POST)
    String hello(@RequestBody FeignUser user);


    @RequestMapping("/getUser")
    FeignUser getMyUser();


    @RequestMapping("/getUser1")
    FeignUser getMyUser(@RequestParam("id") Long id);
}
