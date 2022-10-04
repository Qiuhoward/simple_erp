package com.example.hr_system.controller;


import com.example.hr_system.bean.event.EventMessage;
import com.example.hr_system.bean.login.*;
import com.example.hr_system.bean.login.PeopleEditDto;
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




}
