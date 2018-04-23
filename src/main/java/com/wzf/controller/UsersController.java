package com.wzf.controller;

import com.wzf.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;



    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }
}
