package com.acec.feignconsumer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer(){
        return helloService.hello();
    }


    @RequestMapping(value = "/feign-consumer/user", method = RequestMethod.GET)
    public User helloConsumerUser(){
        return helloService.getMyUser();
    }


    @RequestMapping(value = "/feign-consumer/user1", method = RequestMethod.GET)
    public User helloConsumerUser(Long id){
        return helloService.getMyUser(id);
    }
}
