package com.example.study01.entity;

import com.example.study01.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id @GeneratedValue
    private Integer studentId;

    private String studentName;

    private String studentAddress;
    @Column(nullable = true)
    private Date admissionDate;

    public static Student toEntity(StudentDTO dto) {
        return Student.builder()
                .studentId(dto.getStudentId())
                .studentName(dto.getStudentName())
                .studentAddress(dto.getStudentAddress())
                .admissionDate(dto.getAdmissionDate())
                .build();
    }
}