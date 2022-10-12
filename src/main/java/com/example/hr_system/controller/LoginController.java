package com.example.hr_system.controller;

import com.example.hr_system.bean.LoginDto;
import com.example.hr_system.bean.UserGetDto;
import com.example.hr_system.bean.UserLoginDto;
import com.example.hr_system.bean.event.EventMessage;
import com.example.hr_system.service.LoginService;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = {"*"}) //
public class LoginController {




//permission userid
    @PostMapping(value = "admin_login")
    public EventMessage<UserGetDto> adminLogin(@RequestBody LoginDto loginDto){

        return  LoginService.adminLogin(loginDto);
    }

    @PostMapping(value = "user_login")
    public EventMessage<UserGetDto> userLogin(@RequestBody UserLoginDto userLoginDto){
        return  LoginService.userLogin(userLoginDto);
    }

    }
