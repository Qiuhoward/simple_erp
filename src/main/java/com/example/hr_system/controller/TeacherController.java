package com.example.hr_system.controller;

import com.example.hr_system.bean.ErpQueryDto;
import com.example.hr_system.bean.event.EventMessage;
import com.example.hr_system.entity.TeacherList;
import com.example.hr_system.service.TeacherService;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = {"*"})
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping(value = "query_find_all")
    public EventMessage<ErpQueryDto> queryFindAll(){
        return  teacherService.queryFindAll();
    }

    @GetMapping(value = "query_like")
    public EventMessage<TeacherList> queryLike(@RequestParam String keyword){
        return  teacherService.queryLike(keyword);
    }
    @PutMapping(value = "edit_is_user")
    public EventMessage<String> editIsUser(@RequestParam Long teacherId){
        return  teacherService.editIsUser(teacherId);
    }

    @PutMapping(value = "edit_is_push")
    public EventMessage<String> editIsPush(@RequestParam Long teacherId){
        return  teacherService.editIsPush(teacherId);
    }



}
