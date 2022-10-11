package com.example.hr_system.service;

import com.example.hr_system.bean.AddDto;
import com.example.hr_system.bean.QueryPermissionListDto;
import com.example.hr_system.entity.User;
import com.example.hr_system.entity.UserPermissionList;
import com.example.hr_system.entity.UserProfile;
import com.example.hr_system.repository.UserPermissionListRepository;
import com.example.hr_system.repository.UserProfileRepository;
import com.example.hr_system.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class UserService {


    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;
    private final UserPermissionListRepository userPermissionListRepository;
    private final UserProfileService userProfileService;

    public UserService(UserRepository userRepository, UserProfileRepository userProfileRepository, UserPermissionListRepository userPermissionListRepository, UserProfileService userProfileService) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
        this.userPermissionListRepository = userPermissionListRepository;
        this.userProfileService = userProfileService;
    }
    /**
     *新增帳號
     */
    public String addAccount(AddDto addDto) {
        log.info("執行addUser的參數為:{}", addDto);
        if (!addDto.getPassword2().equals(addDto.getPassword1())) {
            return "輸入密碼不一致";
        }
        List<User> users = userRepository.findByAccountAndEmail(addDto.getAccount(), addDto.getEmail());
      //bug email照理來說一樣也不行新增
        if (!users.isEmpty()) {
            return "已有此帳號";
        }
        User user = new User();
        user.setAccount(addDto.getAccount());
        user.setPassword(addDto.getPassword1());
        user.setEmail(addDto.getEmail());
        userRepository.save(user);
        return userProfileService.addUserProfile(addDto);
    }


    public String queryAccount() {
        return null;
    }

    /**
     *查詢被管理者名單
     */

    public List<QueryPermissionListDto> queryPermissionList(Long userId) {
        log.info("執行queryPermissionList的參數為:{}",userId);
        List<UserPermissionList>userPermissionLists=userPermissionListRepository.findByUserId(userId);
        List<QueryPermissionListDto>queryPermissionListDtos=new ArrayList<>();
        for (UserPermissionList userPermissionList:userPermissionLists) {

           Long  targetId=userPermissionList.getTargetId();
           List<UserProfile> userProfiles = userProfileRepository.findByUserId(targetId);

            QueryPermissionListDto queryPermissionListDto=new QueryPermissionListDto();


            for (UserProfile userProfile:userProfiles) {
                BeanUtils.copyProperties(userProfile,queryPermissionListDto);
                queryPermissionListDtos.add(queryPermissionListDto);
            }

           }

        return queryPermissionListDtos;
    }

    public String login(String account, String password) {
     Optional<User> userOptional=userRepository.findByAccountAndPassword(account,password);
     if(userOptional.isPresent()){
         User user=userOptional.get();
         return "您的人員編號為"+user.getUserId().toString();
     }


        return "帳密錯誤";
    }



}
