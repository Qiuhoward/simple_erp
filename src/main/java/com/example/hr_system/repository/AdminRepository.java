package com.example.hr_system.repository;

import com.example.hr_system.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Long> {


    Optional<Admin>findByUserNameAndPassword(String userName,String password);
}
