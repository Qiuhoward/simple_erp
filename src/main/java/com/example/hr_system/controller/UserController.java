package com.example.hr_system.controller;



import com.example.hr_system.bean.AddDto;
import com.example.hr_system.bean.QueryPermissionListDto;
import com.example.hr_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public  String login(@RequestParam(value="account") String account,@RequestParam(value="password") String password){
        return  userService.login(account,password);
    }


    @GetMapping(value = "query_permission_list")
    public List<QueryPermissionListDto> queryPermissionList(@RequestParam(value="userId") Long userId){
        return  userService.queryPermissionList(userId);
    }



//開關權限




}
