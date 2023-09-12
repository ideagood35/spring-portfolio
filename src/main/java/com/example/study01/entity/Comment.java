package com.example.study01.entity;

import com.example.study01.dto.CommentDTO;
import com.example.study01.dto.TeacherDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {

    @Id @GeneratedValue
    private Long id;

    private String comment;


    public static Comment toEntity(CommentDTO dto) {
        return Comment.builder()
                .id(dto.getId())
                .comment(dto.getComment())
                .build();
    }
}