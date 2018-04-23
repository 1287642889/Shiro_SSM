package com.wzf.controller;

import com.wzf.service.UsersService;
import com.wzf.service.serviceImpl.PasswordUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

/**
 * 登录控制器
 */
@Controller
public class LoginController {
    @Autowired
    private UsersService usersService;

    //进入登录页面
    @GetMapping(value = "/")
    public ModelAndView Index(){
        return new ModelAndView("index");
    }

    //进入登录页面
    @GetMapping(value = "/login")
    public ModelAndView CheckUsers(){
        return new ModelAndView("index");
    }

    //登录
    @PostMapping(value = "/login")
    public ModelAndView login(String userName, String password){
        ModelAndView mav = new ModelAndView();
        String newPassword = PasswordUtil.encodePwd(password);
        UsernamePasswordToken token = new UsernamePasswordToken(userName,newPassword);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            //mav.addObject("currentUser",userName);
            mav.setViewName("main");
            return mav;
        }catch (Exception e){
            e.printStackTrace();
            mav.setViewName("index");
            mav.addObject("error","用户名或密码错误！");
            return mav;
        }
    }

    @RequestMapping("/unauthorized")
    public ModelAndView unauthorized(){
        return new ModelAndView("unauthorized");
    }

    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }
}
