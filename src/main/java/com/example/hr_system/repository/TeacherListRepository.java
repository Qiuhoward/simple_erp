package com.example.hr_system.repository;

import com.example.hr_system.entity.TeacherList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TeacherListRepository extends JpaRepository<TeacherList,Long> {
    List<TeacherList>findByTeacherNameLike(String name);
}
