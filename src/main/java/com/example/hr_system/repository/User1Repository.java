package com.example.hr_system.repository;

import com.example.hr_system.entity.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface User1Repository  extends JpaRepository<User1,Long> {
    Optional<User1> findByPasswordAndEmail(String password, String email);
}
