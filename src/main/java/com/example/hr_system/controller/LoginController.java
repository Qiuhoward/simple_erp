package com.example.hr_system.controller;


import com.example.hr_system.bean.event.EventMessage;
import com.example.hr_system.bean.login.*;
import com.example.hr_system.bean.login.PeopleEditDto;
import com.example.hr_system.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = {"*"}) //
public class LoginController {

    @Autowired
    LoginService  loginService;


    @RequestMapping(value="/add_people",method = RequestMethod.POST) //網址用底線小寫
    public EventMessage<String> addAccount(@RequestBody LoginAddDto loginAddDto){
        return loginService.addPeople(loginAddDto);

    }

    @RequestMapping(value="/get_login",method = RequestMethod.POST) //網址用底線小寫
    public EventMessage<Integer> login(@RequestBody LoginGetDto loginGetDto){
        return loginService.login(loginGetDto);
        //要藏值所以用post(account,password)
    }
    @RequestMapping(value="/edit_people",method = RequestMethod.PUT) //網址用底線小寫
    public EventMessage<String>edit_people(@RequestBody PeopleEditDto peopleEditDto){
        return loginService.update(peopleEditDto);
        //要藏值所以用post(account,password)
    }
    @RequestMapping(value="/del_people",method = RequestMethod.DELETE) //網址用底線小寫
    public EventMessage<String>del_people(@RequestBody LoginDeleteDto loginDeleteDto){
        return loginService.delete(loginDeleteDto);
    }
    @RequestMapping(value="/query_people",method = RequestMethod.GET) //網址用底線小寫
    public EventMessage<List<PeopleGetDto>>query_people(){

        return loginService.query_people();
    }

    @RequestMapping(value="/edit_isLogin",method = RequestMethod.PUT) //權限
    public EventMessage<String> edit_isLogin(int loginId){
        return loginService.edit_isLogin(loginId);
    }

    @RequestMapping(value="/edit_permission",method = RequestMethod.PUT) //修改密碼
    public EventMessage<String> edit_permission(@RequestBody PermissionDto permissionDto){
        return loginService.edit_permission(permissionDto);
    }

//    @RequestMapping(value="/edit_permission",method = RequestMethod.PUT) //修改密碼
//    public EventMessage<String> edit_permission(PermissionDto permissionDto){
//        return loginService.edit_permission(permissionDto);
//    }



//開關權限




}
