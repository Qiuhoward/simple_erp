package com.example.hr_system.repository;

import com.example.hr_system.entity.UserPermissionList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserPermissionListRepository extends JpaRepository<UserPermissionList,Long> {

    List<UserPermissionList>findByUserId(Long userId);
}
