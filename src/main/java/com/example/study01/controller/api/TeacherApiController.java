package com.example.study01.controller.api;

import com.example.study01.dto.CommonResponseDTO;
import com.example.study01.dto.TeacherDTO;
import com.example.study01.entity.Teacher;
import com.example.study01.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController //화면은 안나오는것 @Controller + @ResponseBody
@AllArgsConstructor
@RequestMapping("/api")//공통경로 앞에 추가됨
public class TeacherApiController {
    private TeacherService teacherService;

    //조회:entity ->dto변환
    @GetMapping("/teachers")
    public List<TeacherDTO> getTheacher() {
        List<Teacher> teachers = teacherService.findAll();
        List<TeacherDTO> teacherDTOS = teachers.stream().map(TeacherDTO::toDTO).collect(Collectors.toList());//dto
        return teacherDTOS;//자동으로 json 변환됨
    }
    //조회:entity ->dto 변환해서 화면으로 전송
    @GetMapping("/teacher/{id}")
    public TeacherDTO getTeacher(@PathVariable long id) {
        Teacher teacher = teacherService.findById(id);//entity
        TeacherDTO teacherDTO = TeacherDTO.toDTO(teacher);//dto
        return teacherDTO;//자동으로 json 변환됨
    }

    @GetMapping("/teacher-new")
    public String teacherNewpage() {
        return "teacher/teacher-new";//등록페이드
    }

    @PostMapping("/teacher")//받아준다
    public CommonResponseDTO saveTeacher(@RequestBody TeacherDTO teacherDTO) {
        teacherService.save(teacherDTO);//dto
        CommonResponseDTO responseDTO =new CommonResponseDTO(true,"성공",null);
        return responseDTO;
    }

    @DeleteMapping("/teacher")
    public CommonResponseDTO delTeacher(@RequestBody TeacherDTO teacherDTO){
        CommonResponseDTO responseDTO = new CommonResponseDTO(true,"성공",null);
        return responseDTO;
    }
}
