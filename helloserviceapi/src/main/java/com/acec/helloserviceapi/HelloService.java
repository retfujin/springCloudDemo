package com.acec.helloserviceapi;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/refactor")
public interface HelloService {


    @RequestMapping(value = "/hello4", method= RequestMethod.GET)
    String hello(@RequestParam("name") String name) ;


    @RequestMapping(value= "/hello5", method= RequestMethod.GET)
    User hello(@RequestParam("name") String name, @RequestParam("age") Integer age);

    @RequestMapping(value= "/hello6", method= RequestMethod.POST)
    String hello6(@RequestBody User user);

}
