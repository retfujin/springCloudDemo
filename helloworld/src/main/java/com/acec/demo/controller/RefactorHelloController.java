package com.acec.demo.controller;

import com.acec.helloserviceapi.HelloService;
import com.acec.helloserviceapi.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RefactorHelloController implements HelloService{

    Logger logger = LoggerFactory.getLogger(RefactorHelloController.class);


    @Override
    public String hello(String name) {
        return "Hello"+ name;
    }

    @Override
    public User hello(String name, Integer age) {
        logger.debug("name={},age={}",name,age);
        return new User(name, age);
    }

    @Override
    public String hello6(User user) {

        return "Hi "+ user.getUserName() + ", " + user.getAge();
    }
}
