package com.oright.android.messageapi.web.controller;


import com.oright.android.messageapi.web.model.BaseInfo;
import com.oright.android.messageapi.web.model.User;
import com.oright.android.messageapi.web.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/base")
public class BaseController {
    @Autowired
    private BaseService baseService;
    //登陆接口
    @PostMapping("/login")
    public BaseInfo login(@RequestBody User user){
        return baseService.login(user);
    }
    //注册接口
    @PostMapping("/register")
    public BaseInfo register(@RequestBody User user){
        return baseService.register(user);
    }
    //用户名是否重复接口
    @GetMapping("/isRepeat")
    public BaseInfo foundUserNameIsRepeat(String userName){
        System.out.println(userName);
        return baseService.foundUserNameIsRepeat(userName);
    }
    @GetMapping("/findUserBaseInfo")
    public User findUserBaseInfo(String userName){
        return baseService.findUserBaseInfo(userName);
    }

}













