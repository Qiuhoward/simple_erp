package com.example.hr_system.repository;

import com.example.hr_system.entity.Login;
import com.example.hr_system.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Integer> {
}
