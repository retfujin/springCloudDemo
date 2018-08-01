package com.acec.feignconsumer;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallback implements HelloService {

    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello(String name) {
        return "error";
    }

    @Override
    public FeignUser hello(String name, Integer age) {
        return new FeignUser("未知", 0);
    }

    @Override
    public String hello(FeignUser user) {
        return "error";
    }

    @Override
    public FeignUser getMyUser() {
        return null;
    }

    @Override
    public FeignUser getMyUser(Long id) {
        return null;
    }
}

