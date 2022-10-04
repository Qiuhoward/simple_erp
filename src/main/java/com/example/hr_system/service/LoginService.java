package com.example.hr_system.service;

import com.example.hr_system.bean.login.LoginDeleteDto;
import com.example.hr_system.bean.login.LoginGetDto;
import com.example.hr_system.bean.event.EventMessage;
import com.example.hr_system.bean.login.LoginAddDto;
import com.example.hr_system.bean.login.PeopleEditDto;
import com.example.hr_system.entity.Login;
import com.example.hr_system.entity.People;
import com.example.hr_system.repository.LoginRepository;
import com.example.hr_system.repository.PeopleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;
    @Autowired
    PeopleRepository peopleRepository;

    /**
     * action:新增
     * condition:密碼不重複 and 登入 logins.size!=0 代表有建立過成list
     * @param loginAddDto
     * @return
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
        List<Login> logins =loginRepository.findByAccount(account);
        if(logins.size() !=0){
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
        loginRepository.save(login);
        return eventMessage.setDefaultEventMessage("新增成功");
    }



    /**
     *
     * 登入查詢 員工編號
     * 多想if條件設身處地
     * @param loginGetDto
     * @return
     */
    public EventMessage<Integer> login(LoginGetDto loginGetDto) {
        log.info("login:{}", loginGetDto);
        String account = loginGetDto.getLoginAccount();
        String password = loginGetDto.getPassword();
        EventMessage eventMessage = new EventMessage();
        List<Login> logins= loginRepository.findByAccountAndPassword(account, password);
        //System.out.println.(logins);
        if(logins.size()==0) {
              return eventMessage.GetEeceptionMessage("1003", "帳號密碼錯誤");
        }
        if(logins.size()!=1){
            log.debug("帳號出現重複的問題");//自己debug用的 防呆機制
        }

        Login login=logins.get(0);   //excel
        int loginId=login.getLoginId();
        return eventMessage.setDefaultEventMessage(loginId);
    }

    /**
     *
     * 登入後更新人事資料
     * @param peopleEditDto
     * @return
     */
    public EventMessage<String> update(PeopleEditDto peopleEditDto) {
        int loginId=peopleEditDto.getLoginId();
        EventMessage eventMessage = new EventMessage();
        Login login = loginRepository.findById(loginId).get();
        int peopleId=login.getPeopleId();
        People people =peopleRepository.findById(peopleId).get();
        BeanUtils.copyProperties(peopleEditDto, people);
        peopleRepository.save(people);
        return eventMessage.setDefaultEventMessage("修改成功");
    }

    /**
     * 刪除員工資料
     * @param loginDeleteDto
     * @return
     */
    public EventMessage<String> delete(LoginDeleteDto loginDeleteDto) {
        int loginId=loginDeleteDto.getLoginId();
        int peopleId=loginDeleteDto.getPeopleId();
        EventMessage eventMessage = new EventMessage();
        loginRepository.deleteById(loginId);
        peopleRepository.deleteById(peopleId);
        return  eventMessage.setDefaultEventMessage("刪除成功");
    }


}

// findByAccountAndPassword跟資料庫裡資料對答案
//     我原來寫的 :
//        if(password.equals(login.getPasseord())&&account.equals(login.getAccount())){
//            return  eventMessage.setDefaultEventMessage();
//        }
//        return eventMessage.GetEeceptionMessage("1001","登入失敗");
//    }







