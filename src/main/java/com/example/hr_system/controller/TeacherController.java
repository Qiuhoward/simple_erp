package com.example.hr_system.controller;

import com.example.hr_system.bean.ErpQueryDto;
import com.example.hr_system.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @GetMapping(value = "query_teacher_list")
    public List<ErpQueryDto> queryTeacherList(@RequestParam(value = "name") String name){
        return  teacherService.queryTeacherList(name);
    }
}
