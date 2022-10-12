package com.example.hr_system.repository;

import com.example.hr_system.entity.TeacherList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TeacherListRepository extends JpaRepository<TeacherList,Long> {

    @Query(value = "select t from TeacherList t where t.account like %?1% or t.changingPersonnel like %?1%  or t.teacherName like %?1%")
    List<TeacherList>findByTeacherNameLikeOrAccountLikeOrEnableLikeOrPushLikeOrChangingPersonnelLike(String keyword);

}
