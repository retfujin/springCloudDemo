package com.acec.ribbonconsumer.controller;

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

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
    }

    @RequestMapping(value = "/ribbon-consumer-user", method = RequestMethod.GET)
    public String user1Consumer(@RequestParam String allRequestParams) {
        Map<String,String> postData = new HashMap();
        postData.put("allRequestParams", allRequestParams);
        JSONObject jsonObject = restTemplate.getForEntity("http://HELLO-SERVICE/getUser1?allRequestParams="+allRequestParams,JSONObject.class,postData).getBody();
        if(jsonObject==null){
            return "没有数据";
        }else{
            return jsonObject.toJSONString();
        }

    }
}

