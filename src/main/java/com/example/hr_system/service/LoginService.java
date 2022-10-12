package com.example.hr_system.service;

import com.example.hr_system.bean.LoginDto;
import com.example.hr_system.bean.UserGetDto;
import com.example.hr_system.bean.UserLoginDto;
import com.example.hr_system.bean.event.EventMessage;
import com.example.hr_system.entity.Admin;
import com.example.hr_system.entity.User1;
import com.example.hr_system.repository.AdminRepository;
import com.example.hr_system.repository.User1Repository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LoginService {

    private static AdminRepository adminRepository;
    private static  User1Repository user1Repository;

    public LoginService(AdminRepository adminRepository, User1Repository user1Repository) {
        this.adminRepository = adminRepository;
        this.user1Repository = user1Repository;
    }

    public static EventMessage<UserGetDto> adminLogin(LoginDto loginDto) {
            Optional<Admin> adminOptional= adminRepository.findByUserNameAndPassword(loginDto.getAccount(),loginDto.getPassword());
            UserGetDto userGetDto=new UserGetDto();

            EventMessage eventMessage=new EventMessage();
            if(adminOptional.isPresent()){
                Admin admin=adminOptional.get();
                userGetDto.setPermission("admin");
                userGetDto.setUserId(admin.getId());
                return eventMessage.setDefaultEventMessage(userGetDto);
            }

            return eventMessage.GetEeceptionMessage("1001","帳密錯誤");
        }


    public static EventMessage<UserGetDto>userLogin(UserLoginDto userLoginDto) {
        Optional<User1> user1Optional= user1Repository.findByPasswordAndEmail(userLoginDto.getPassword(),userLoginDto.getEmail());
        UserGetDto userGetDto=new UserGetDto();
        EventMessage eventMessage=new EventMessage();
        if(user1Optional.isPresent()){
            User1 user1=user1Optional.get();
            userGetDto.setPermission("user");
            userGetDto.setUserId(user1.getId());
            return eventMessage.setDefaultEventMessage(userGetDto);
        }

        return eventMessage.GetEeceptionMessage("1001","帳密錯誤");
    }

}

