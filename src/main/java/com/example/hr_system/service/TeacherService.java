package com.example.hr_system.service;

import com.example.hr_system.bean.ErpQueryDto;
import com.example.hr_system.entity.TeacherList;
import com.example.hr_system.repository.TeacherListRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TeacherService {


    private final TeacherListRepository teacherListRepository;

    public TeacherService(TeacherListRepository teacherListRepository) {
        this.teacherListRepository = teacherListRepository;
    }

    public List<ErpQueryDto> queryTeacherList(String name){
        log.info("執行queryTeacherList的參數為:{}",name);
        List<ErpQueryDto>erpQueryDtos=new ArrayList<>();
       List<TeacherList> teacherLists =teacherListRepository.findByTeacherNameLike(name);
        ErpQueryDto erpQueryDto=new ErpQueryDto();
        for (TeacherList teacherList:teacherLists) {
            BeanUtils.copyProperties(teacherList,erpQueryDto);
            erpQueryDtos.add(erpQueryDto);
        }

        return  erpQueryDtos ;
    }

}
