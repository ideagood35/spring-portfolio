package com.example.study01.dto;

import com.example.study01.entity.Student;
import com.example.study01.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherDTO {

    private Long id;

    private String name;

    private String subject;


    public static TeacherDTO toDTO(Teacher entity) {
        return TeacherDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .subject(entity.getSubject())
                .build();
    }
}
