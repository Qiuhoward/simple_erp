package com.example.hr_system.controller;

import com.example.hr_system.bean.LoginDto;
import com.example.hr_system.service.LoginService;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*"}) //
public class LoginController {

    @Autowired
    LoginService  loginService;


    @RequestMapping(value="/add_login",method = RequestMethod.POST) //網址用底線小寫
    public String addAccount(@RequestBody LoginDto loginDto){
        System.out.println(loginDto);
        return null;
    }
//,method = RequestMethod.POST


}
