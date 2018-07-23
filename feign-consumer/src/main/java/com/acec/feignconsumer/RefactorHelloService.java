package com.acec.feignconsumer;

import com.acec.helloserviceapi.HelloService;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("hello-service")
public interface RefactorHelloService extends HelloService {
}
