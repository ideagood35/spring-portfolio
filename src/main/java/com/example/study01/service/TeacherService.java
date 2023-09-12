package com.example.study01.service;

import com.example.study01.dto.TeacherDTO;
import com.example.study01.entity.Teacher;
import com.example.study01.repo.TeacherRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {
    private TeacherRepo teacherRepo;

    //여러게 조회
    public List<Teacher> findAll() {
        List<Teacher> teacherList = teacherRepo.findAll();
        return teacherList;
    }

    //단건 조회
    public Teacher findById(Long id) {
        Teacher teacher = teacherRepo.findById(id).orElse(null);
        return teacher;
    }

    //생성/수정:화면에서 넘어온 dto->entity 변혼해서 저장
    public Teacher save(TeacherDTO teacherDTO) {
        return teacherRepo.save(Teacher.toEntity(teacherDTO));
    }

    //삭제: 화면에서 넘어온 dto-> entity 변환해서 삭제
    public void delete(TeacherDTO teacherDTO) {
        teacherRepo.delete(Teacher.toEntity(teacherDTO));
    }
}
