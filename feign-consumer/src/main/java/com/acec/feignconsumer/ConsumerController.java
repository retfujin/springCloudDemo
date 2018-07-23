package com.acec.feignconsumer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private RefactorHelloService refactorHelloService;


    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer(){
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer2", method = RequestMethod.GET)
    public String helloConsumer2(){
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("DIDI")).append("\n");
        sb.append(helloService.hello("DIDI",30)).append("\n");
        sb.append(helloService.hello(new User("nickNamew","ze@153.com","DiDi","pass","2018-10-01"))).append("\n");
        return sb.toString();
    }


    @RequestMapping(value = "/feign-consumer3", method = RequestMethod.GET)
    public String helloConsumer3() {
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("MIMI")). append("\n");
        sb.append(refactorHelloService.hello("MIMI", 20)).append("\n");
        sb.append(refactorHelloService.hello(new com.acec.helloserviceapi.User("MIMI",30))).append("\n");
        return sb.toString();
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
