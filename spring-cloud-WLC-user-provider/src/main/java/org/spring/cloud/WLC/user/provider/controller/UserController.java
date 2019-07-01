package org.spring.cloud.WLC.user.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.wlc.base.domain.user.User;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping(value = "/getUser/{id}")
    public User getUser(@PathVariable Long id){
        User user=new User();
        user.setId(id);
        user.setName("李四");
        user.setAge(18);
        return user;
    }
    @GetMapping(value = "/getName")
    public String getName(){
        return "李四";
    }
}
