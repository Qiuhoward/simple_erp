package com.example.hr_system.repository;

import com.example.hr_system.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginRepository extends JpaRepository<Login, Integer> {
     List<Login>findByAccountAndPassword(String account,String password); //可自動生成find
     List<Login>findByAccount(String account);

}
