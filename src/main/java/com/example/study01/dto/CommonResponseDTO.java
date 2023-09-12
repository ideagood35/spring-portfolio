package com.example.study01.dto;

import com.example.study01.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonResponseDTO {
    private boolean success;
    private String msg;
    private Object data;
}
