package com.example.study01.service;

import com.example.study01.dto.CommentDTO;
import com.example.study01.entity.Comment;
import com.example.study01.repo.CommentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {
    private CommentRepo commentRepo;

    //여러게 조회
    public List<Comment> findAll() {
        return commentRepo.findAll();
    }

    //단건 조회
    public Comment findById(Long id) {
        Comment comment = commentRepo.findById(id).orElse(null);
        return comment;
    }

    //생성/수정:화면에서 넘어온 dto->entity 변혼해서 저장
    public Comment save(CommentDTO commentDTO) {
        return commentRepo.save(Comment.toEntity(commentDTO));
    }

    //삭제: 화면에서 넘어온 dto-> entity 변환해서 삭제
    public void delete(CommentDTO commentDTO) {
        commentRepo.delete(Comment.toEntity(commentDTO));
    }
}
