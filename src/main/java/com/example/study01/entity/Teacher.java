package com.example.study01.entity;

import com.example.study01.dto.StudentDTO;
import com.example.study01.dto.TeacherDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private String subject;

    public static Teacher toEntity(TeacherDTO dto) {
        return Teacher.builder()
                .id(dto.getId())
                .name(dto.getName())
                .subject(dto.getSubject())
                .build();
    }
}