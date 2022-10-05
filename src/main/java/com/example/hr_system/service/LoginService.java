package com.example.hr_system.service;

import com.example.hr_system.bean.login.*;
import com.example.hr_system.bean.event.EventMessage;
import com.example.hr_system.entity.Login;
import com.example.hr_system.entity.People;
import com.example.hr_system.repository.LoginRepository;
import com.example.hr_system.repository.PeopleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;
    @Autowired
    PeopleRepository peopleRepository;

    /**
     * 修改密碼
     */
    public EventMessage<String> edit_password(PasswordEditDto passwordEditDto) {
        EventMessage eventMessage = new EventMessage();
        String oldPassword = passwordEditDto.getOldPassword();
        String newPassword1 = passwordEditDto.getNewPassword1();
        String newPassword2 = passwordEditDto.getNewPassword2();
        int loginId= passwordEditDto.getLoginId();

        if (!newPassword1.equals(newPassword2)) {
            return eventMessage.GetEeceptionMessage("1001", "密碼不一致");
        }
        Login login= loginRepository.findById(loginId).get();
        if(!login.getPassword().equals(oldPassword)){
            return eventMessage.GetEeceptionMessage("1005", "密碼不正確");
        }

        //System.out.println(logins.size());
        login.setPassword(newPassword1);
        loginRepository.save(login);
        return eventMessage.setDefaultEventMessage("修改成功");
    }

    /**
     *修改權限
     */
    public EventMessage<String> edit_permission(PermissionDto permissionDto) {
        EventMessage eventMessage = new EventMessage();
        int peopleId= permissionDto.getPeopleId();
        People people=peopleRepository.findById(peopleId).get();
        //System.out.println(logins.size());
        people.setPermission("boss");
        peopleRepository.save(people);
        return eventMessage.setDefaultEventMessage("修改成功");
    }


    /**
     * action:新增資料
     */

    public EventMessage<String> addPeople(LoginAddDto loginAddDto) {

        log.info("addPeople參數為:{}", loginAddDto);
        String account = loginAddDto.getLoginAccount();
        String password = loginAddDto.getPassword1();
        String password2 = loginAddDto.getPassword2();
        EventMessage eventMessage = new EventMessage();

        if (!password.equals(password2)) {
            return eventMessage.GetEeceptionMessage("1001", "密碼不一致");
        }
        List<Login> logins = loginRepository.findByAccount(account); //帳號可能為複數用list
        if (logins.size() != 0) {
            return eventMessage.GetEeceptionMessage("1002", "帳號重複");
        }
        People people = new People();
        System.out.println(people);
        people = peopleRepository.save(people);    //本來無id放到資料庫裡會新增id再丟回people
        System.out.println(people);
        int peopleId = people.getPeopleId();

        Login login = new Login();
        login.setPeopleId(peopleId);
        login.setAccount(account);
        login.setPassword(password);
        login.setIsLogin(true);
        loginRepository.save(login);
        return eventMessage.setDefaultEventMessage("新增成功");
    }


    /**
     * 登入查詢
     */
    public EventMessage<Integer> login(LoginGetDto loginGetDto) {

        log.info("login:{}", loginGetDto);
        String account = loginGetDto.getLoginAccount();
        String password = loginGetDto.getPassword();
        EventMessage eventMessage = new EventMessage();
        List<Login> logins = loginRepository.findByAccountAndPassword(account, password);
        System.out.println(logins);
        if (logins.size() == 0) {
            return eventMessage.GetEeceptionMessage("1003", "帳號密碼錯誤");
        }
        if (logins.size() != 1) {
            log.debug("帳號出現重複的問題");//自己debug用的 防呆機制
        }
        Login login = logins.get(0);
        if (!login.getIsLogin()) {
            return eventMessage.GetEeceptionMessage("1004", "使用者已被停用請聯繫工作人員");
        }

        //excel
        int loginId = login.getLoginId();
        return eventMessage.setDefaultEventMessage(loginId);
    }

    /**
     * 登入後更新人事資料
     */
    public EventMessage<String> update(PeopleEditDto peopleEditDto) {
        EventMessage eventMessage = new EventMessage();
        int loginId = peopleEditDto.getLoginId();
        Login login = loginRepository.findById(loginId).get(); //用get因為你只有一個id當然只會有一個物件
        int peopleId = login.getPeopleId();
        People people = peopleRepository.findById(peopleId).get();
        BeanUtils.copyProperties(peopleEditDto, people);
        peopleRepository.save(people);
        System.out.println(people);
        return eventMessage.setDefaultEventMessage("修改成功");

    }

    /**
     * 刪除員工資料
     */
    public EventMessage<String> delete(LoginDeleteDto loginDeleteDto) {
        int loginId = loginDeleteDto.getLoginId();
        int peopleId = loginDeleteDto.getPeopleId();
        EventMessage eventMessage = new EventMessage();
        loginRepository.deleteById(loginId);
        peopleRepository.deleteById(peopleId);
        System.out.println(peopleRepository);
        System.out.println(loginRepository);
        return eventMessage.setDefaultEventMessage("刪除成功");
    }

    /**
     *查詢使用者資訊
     */
    public EventMessage<List<PeopleGetDto>> query_people() {

        EventMessage eventMessage = new EventMessage();


        List<People> peoples = peopleRepository.findAll();

        List<PeopleGetDto> peopleGetDtos = new ArrayList<>();

        for (People people : peoples) {
            PeopleGetDto peopleGetDto = new PeopleGetDto();
            BeanUtils.copyProperties(people, peopleGetDto);
            System.out.println(people);
            System.out.println(peopleGetDto);
            peopleGetDtos.add(peopleGetDto);

        }
//
//        return  eventMessage.setDefaultEventMessage(peopleGetDtos);
        return null;
    }

    /**
     * 修改使用者登入
     */
    public EventMessage<String> edit_isLogin(int loginId) {
        // System.out.println(loginId);測試
//        Login login =loginRepository.findById(loginId).get();
        EventMessage eventMessage = new EventMessage();
        Login login = loginRepository.findById(loginId).get();
        Boolean isLoginInfo = login.getIsLogin();
        Boolean newIsLoginInfo = !isLoginInfo;
        login.setIsLogin(newIsLoginInfo);
        loginRepository.save(login);

        return eventMessage.setDefaultEventMessage("修改成功");
    }
}


//    public EventMessage<String> edit_permission(PermissionDto permissionDto) {
//
//
//        return ;
//    }
//}

// findByAccountAndPassword跟資料庫裡資料對答案
//     我原來寫的 :
//        if(password.equals(login.getPasseord())&&account.equals(login.getAccount())){
//            return  eventMessage.setDefaultEventMessage();
//        }
//        return eventMessage.GetEeceptionMessage("1001","登入失敗");
//    }






