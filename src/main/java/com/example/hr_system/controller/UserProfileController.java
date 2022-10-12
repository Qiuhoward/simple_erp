package com.example.hr_system.controller;

import com.example.hr_system.bean.EditDto;
import com.example.hr_system.service.UserProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"*"})
public class UserProfileController {


    private final UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PutMapping(value ="edit_profile")
    public String editProfile(@RequestBody EditDto editDto, @RequestParam(value = "userId") Long userId){
        return userProfileService.editProfile(editDto,userId);
    }
}
