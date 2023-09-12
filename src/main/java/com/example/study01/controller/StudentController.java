package com.example.study01.controller;

import com.example.study01.dto.StudentDTO;
import com.example.study01.entity.Student;
import com.example.study01.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;


    @GetMapping("/students")
    public String getStudents(Model model) {
        List<Student> studentsList = studentService.findAll();
        System.out.println(studentsList);
        model.addAttribute("students", studentsList);
        return "students";
    }

    @GetMapping("/student/{studentId}")
    public String newStudent(@PathVariable Integer studentId, Model model) {
        Student student = studentService.findById(studentId);
        System.out.println(student);
        model.addAttribute("student", student);
        return "student";
    }

    @GetMapping("/new-student")
    public String newStudent() {
        return "new-student";
    }

    @PostMapping("/new-student")//받아준다
    public String newStudentPost(@ModelAttribute StudentDTO studentDTO) {
        System.out.println(studentDTO);
        studentService.save(studentDTO);
        return "redirect:students";
    }

    @PostMapping("/del-student")
    public String delStudent(@ModelAttribute StudentDTO studentDTO) {
        System.out.println(studentDTO);
        studentService.delete(studentDTO);
        return "redirect:students";
    }
}
