package com.walker.ribbonbalancer.endpoint;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.walker.ribbonbalancer.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IUserService userService;

    @GetMapping("/add")
    public String add(int a, int b) {
        String result = restTemplate.getForObject("http://demo-client1/add?a=" + a + "&b="+b, String.class);

        System.out.println(result);
        return result;
    }


    @GetMapping("/get")
    public String get(String user) throws Exception {
        return userService.getUser(user);
    }


}
