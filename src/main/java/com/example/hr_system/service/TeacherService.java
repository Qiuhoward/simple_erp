package com.example.hr_system.service;

import com.example.hr_system.bean.AdminAddDto;
import com.example.hr_system.bean.ErpQueryDto;
import com.example.hr_system.bean.event.EventMessage;
import com.example.hr_system.entity.TeacherList;
import com.example.hr_system.repository.TeacherListRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TeacherService {


    private final TeacherListRepository teacherListRepository;
    public TeacherService(TeacherListRepository teacherListRepository) {
        this.teacherListRepository = teacherListRepository;
    }


    public EventMessage<ErpQueryDto> queryFindAll() {
        EventMessage eventMessage=new EventMessage();

        return eventMessage.setDefaultEventMessage(teacherListRepository.findAll());
    }

    public EventMessage<TeacherList> queryLike(String keyword) {
        EventMessage eventMessage=new EventMessage();
       List<TeacherList>teacherLists=teacherListRepository.findByTeacherNameLikeOrAccountLikeOrEnableLikeOrPushLikeOrChangingPersonnelLike(keyword);
//
       return eventMessage.setDefaultEventMessage(teacherLists);
    }
    public EventMessage<String>addTeacher(AdminAddDto adminAddDto){
        EventMessage eventMessage=new EventMessage();
        TeacherList teacherList=new TeacherList();
        teacherList.setTeacherName(adminAddDto.getTeacherName());
        teacherList.setAccount(adminAddDto.getAccount());
        return eventMessage.setDefaultEventMessage("A");
    }


    public EventMessage<String> editIsUser(Long teacherId) {
       Optional<TeacherList>teacherListOptional=teacherListRepository.findById(teacherId);
        EventMessage eventMessage=new EventMessage();
       if(teacherListOptional.isPresent()){
           TeacherList teacherList=teacherListOptional.get();
            teacherList.setEnable(!teacherList.getEnable());
            teacherListRepository.save(teacherList);
           return eventMessage.setDefaultEventMessage("修改成功");
       }
       return eventMessage.GetEeceptionMessage("1004","查無此id") ;
    }
    public EventMessage<String> editIsPush(Long teacherId) {
        Optional<TeacherList>teacherListOptional=teacherListRepository.findById(teacherId);
        EventMessage eventMessage=new EventMessage();
        if(teacherListOptional.isPresent()){
            TeacherList teacherList=teacherListOptional.get();
            teacherList.setPush(!teacherList.getPush());
            teacherListRepository.save(teacherList);
            return eventMessage.setDefaultEventMessage("修改成功");
        }
        return eventMessage.GetEeceptionMessage("1004","查無此id") ;
    }
}
