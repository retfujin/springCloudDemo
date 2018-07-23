package com.acec.demo.controller;

import com.acec.helloserviceapi.HelloService;
import com.acec.helloserviceapi.User;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RefactorHelloController implements HelloService{


    @Override
    public String hello(String name) {
        return "Hello"+ name;
    }

    @Override
    public User hello(String name, Integer age) {
        return new User(name, age);
    }

    @Override
    public String hello(User user) {
        return "Hello "+ user.getUserName() + ", " + user.getAge();
    }
}
