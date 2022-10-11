package com.example.hr_system.service;


import com.example.hr_system.bean.AddDto;
import com.example.hr_system.bean.EditDto;
import com.example.hr_system.entity.UserProfile;
import com.example.hr_system.repository.UserProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserProfileService {


    private final UserProfileRepository userProfileRepository;

    public UserProfileService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    /**
     * 新增人事資料和新增帳號同步
     */
    public String addUserProfile(AddDto addDto) {
        log.info("執行addUserProfile的參數為:{}", addDto);
        UserProfile userProfile=new UserProfile();
        userProfile.setName(addDto.getName());
        userProfile.setBirthday(addDto.getBirthday());
        userProfile.setGender(addDto.getGender());
        userProfile.setCellphoneNumber(addDto.getCellphoneNumber());
        userProfileRepository.save(userProfile);

        return "新增成功" ;
    }


    public String editProfile(EditDto editDto,Long userId) {
    List<UserProfile> userProfiles=userProfileRepository.findByUserId(userId);
        System.out.println(userProfiles.get(0));
        BeanUtils.copyProperties(userProfiles,editDto);
        return "修改成功";
    }
}
