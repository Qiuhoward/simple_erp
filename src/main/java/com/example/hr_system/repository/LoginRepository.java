package com.example.hr_system.repository;

import com.example.hr_system.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Integer> {

    String addByaccountIdByPwd1ByPwd2(String account,String password);
}
