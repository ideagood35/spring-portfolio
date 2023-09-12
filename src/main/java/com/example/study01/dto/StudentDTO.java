package com.example.study01.dto;

import com.example.study01.entity.Student;
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
public class StudentDTO {

    private Integer studentId;

    private String studentName;

    private String studentAddress;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date admissionDate;


    public static StudentDTO toDTO(Student entity) {
        return StudentDTO.builder()
                .studentId(entity.getStudentId())
                .studentName(entity.getStudentName())
                .studentAddress(entity.getStudentAddress())
                .admissionDate(entity.getAdmissionDate())
                .build();
    }
}
