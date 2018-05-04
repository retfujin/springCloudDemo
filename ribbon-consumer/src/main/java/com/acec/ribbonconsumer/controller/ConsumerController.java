package com.acec.ribbonconsumer.controller;

import com.acec.ribbonconsumer.domain.User;
import com.acec.ribbonconsumer.service.HelloService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConsumerController {


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.helloService();
    }

    @RequestMapping(value = "/ribbon-consumer-user", method = RequestMethod.GET)
    public User user1Consumer(@RequestParam Long id) {

        User user = helloService.find(id);

        return user;

    }
}

