package com.acec.ribbonconsumer.service;


import com.acec.ribbonconsumer.domain.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class HelloService {

    Logger logger = LoggerFactory.getLogger(HelloService.class);

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService(){
        long start = System.currentTimeMillis();

        String  bodyString = restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();

        long end= System.currentTimeMillis();

        logger.info("Spend time : "+ (end - start));

        return bodyString;
    }


    public User find(Long id){
        long start = System.currentTimeMillis();

        User user = restTemplate.getForObject("http://HELLO-SERVICE/getUser1?id={1}",User.class,id);

        long end= System.currentTimeMillis();

        logger.info("Spend find time : "+ (end - start));

        return user;
    }

    public String helloFallback(){
        return "my error";
    }
}
