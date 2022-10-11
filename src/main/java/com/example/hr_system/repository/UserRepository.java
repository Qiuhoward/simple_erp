package com.example.hr_system.repository;

import com.example.hr_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Long> {
   List<User>findByAccountAndEmail(String account,String email);


   Optional<User> findByAccountAndPassword(String account, String password);

}
