package com.acec.feignconsumer;


import com.acec.helloserviceapi.User;
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
        sb.append(helloService.hello("DIDI1")).append("\n");
        sb.append(helloService.hello("DIDI2",30)).append("\n");
        sb.append(helloService.hello(new FeignUser("nickNamew","ze@153.com","DiDi3","pass","2018-10-01"))).append("\n");
        return sb.toString();
    }


    @RequestMapping(value = "/feign-consumer3", method = RequestMethod.GET)
    public String helloConsumer3() {
        StringBuilder sb = new StringBuilder();
      //  sb.append(refactorHelloService.hello("MIMI1")). append("<br/>");
      //  sb.append(refactorHelloService.hello("MIMI2", 20)).append("<br/>");
        sb.append(refactorHelloService.hello6(new User("nickNamew","ze@153.com","MIMI3","pass","2019-10-01"))).append("<br/>");
        return sb.toString();
    }




@RequestMapping(value = "/feign-consumer/user", method = RequestMethod.GET)
    public FeignUser helloConsumerUser(){
        return helloService.getMyUser();
    }


    @RequestMapping(value = "/feign-consumer/user1", method = RequestMethod.GET)
    public FeignUser helloConsumerUser(Long id){
        return helloService.getMyUser(id);
    }
}
