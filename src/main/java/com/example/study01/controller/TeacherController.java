package com.example.study01.controller;

import com.example.study01.dto.StudentDTO;
import com.example.study01.dto.TeacherDTO;
import com.example.study01.entity.Student;
import com.example.study01.entity.Teacher;
import com.example.study01.service.StudentService;
import com.example.study01.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class TeacherController {
    private TeacherService teacherService;

//조회:entity ->dto변환
    @GetMapping("/teachers")
    public String teacherListPage(Model model) {
        List<Teacher> teachers = teacherService.findAll();
        List<TeacherDTO> teacherDTOS = teachers.stream().map(TeacherDTO::toDTO).collect(Collectors.toList());
        model.addAttribute("teachers", teacherDTOS);
        return "teacher/teachers";//목록 페이지
    }

    @GetMapping("/teacher/{id}")
    public String teacherDetailPage(@PathVariable long id, Model model) {
        Teacher teacher = teacherService.findById(id);
        TeacherDTO teacherDTO = TeacherDTO.toDTO(teacher);
        model.addAttribute("teacher", teacher);
        return "teacher/teacher";//상세페이지
    }
    @GetMapping("/teacher-new")
    public String teacherNewpage() {
        return "teacher/teacher-new";//등록페이드
    }

    @PostMapping("/save-teacher")//받아준다
    public String saveTeacher(@ModelAttribute TeacherDTO teacherDTO) {
        teacherService.save(teacherDTO);
        return "redirect:teachers";
    }

    @PostMapping("/del-teacher")
    public String delStudent(@ModelAttribute TeacherDTO teacherDTO) {
        teacherService.delete(teacherDTO);
        return "redirect:teachers";
    }
}
