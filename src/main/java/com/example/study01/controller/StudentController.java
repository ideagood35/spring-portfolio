package com.example.study01.controller;

import com.example.study01.dto.CommentDTO;
import com.example.study01.dto.StudentDTO;
import com.example.study01.dto.TeacherDTO;
import com.example.study01.entity.Comment;
import com.example.study01.entity.Student;
import com.example.study01.service.CommentService;
import com.example.study01.service.StudentService;
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
public class StudentController {
    private StudentService studentService;
    private CommentService commentService;


    @GetMapping("/students")
    public String getStudents(Model model) {
        List<Student> studentsList = studentService.findAll();
        List<StudentDTO> studentDTOS = studentsList.stream().map(StudentDTO::toDTO).collect(Collectors.toList());;
        List<Comment> commentList = commentService.findAll();
        List<CommentDTO> commentDTOS = commentList.stream().map(CommentDTO::toDTO).collect(Collectors.toList());;

        model.addAttribute("students", studentsList);
        model.addAttribute("comments", commentList);
        return "students";
    }

    @GetMapping("/student/{studentId}")
    public String newStudent(@PathVariable Integer studentId, Model model) {
        Student student = studentService.findById(studentId);
        StudentDTO studentDTO = StudentDTO.toDTO(student);//entity(db정보넣는통)-->dto(화면에 전달하고 받는통)
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
