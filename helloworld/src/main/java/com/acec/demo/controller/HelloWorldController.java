/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acec.demo.controller;

import com.acec.demo.domain.User;
import com.acec.demo.domain.UserRepository;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author fujd
 */
@RestController
public class HelloWorldController {

    Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/hello")
    public String index() {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello, host:" + instance.getHost() + "， service id:" + instance.getServiceId());
        return "Hello World";
    }

    @RequestMapping("/hello1")
    public String hello1(@RequestParam String name) {

        return "name="+name;
    }

    @RequestMapping("/hello2")
    public User hello2(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
        User user = new User();
        user.setUserName(name);
        user.setAge(age);
        return user;
    }

    @RequestMapping("/hello3")
    public String hello3(@RequestBody User user){

        return user.toString();

    }

    @RequestMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setUserName("小明");
        user.setPassWord("xxxxxxx");
        return user;
    }

    @RequestMapping("/getUser1")
    @Cacheable(value = "user-key1")
    public User getUser1(@RequestParam Long id) {
        User user = userRepository.findById(id);
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }

    @RequestMapping("/getUserName")
    @Cacheable(value = "user-key2")
    public User getUserName(@RequestParam(required = false) String name) {
        User user = userRepository.findByUserNameOrEmail(name,null);
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }

    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
}
