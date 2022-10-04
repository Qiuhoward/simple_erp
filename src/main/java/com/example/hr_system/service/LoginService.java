package com.example.hr_system.service;

import com.example.hr_system.bean.LoginDto;
import com.example.hr_system.entity.Login;
import com.example.hr_system.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {


    @Autowired
    static
    Login login;

    @Autowired
    LoginRepository  loginRepository;

    public String addPeople(LoginDto loginDto){
        String account= loginDto.getLoginAccount();
        String password= loginDto.getPassword1();
        String password2= loginDto.getPassword2();
        if(!password.equals(password2)){
            return "密碼不一致";
        }
        loginDto.setLoginAccount(account);
        loginDto.setPassword1(password);

        return "新增成功" ;
    }


}
