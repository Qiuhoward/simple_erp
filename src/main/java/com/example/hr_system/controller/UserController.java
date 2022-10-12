package com.example.hr_system.controller;



import com.example.hr_system.bean.AddDto;
import com.example.hr_system.bean.LoginDto;
import com.example.hr_system.bean.event.EventMessage;
import com.example.hr_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*"}) //
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @PostMapping(value = "add_account")
    public  String addAccount(@RequestBody AddDto addDto){
        return userService.addAccount(addDto);
    }

    @PostMapping(value = "login")
    public EventMessage<Integer> login(@RequestBody LoginDto loginDto){
        return  userService.login(loginDto);
    }







//開關權限




}
