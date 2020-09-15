package com.walker.ribbonbalancer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{


    @HystrixCommand(fallbackMethod = "getDefaultUser")
    public String getUser(String user) throws Exception {
        if ("spring".equals(user)) {
            return "success";
        }
        throw new Exception();
    }

    public String getDefaultUser(String user) {
        return "type the wrong user";
    }
}
