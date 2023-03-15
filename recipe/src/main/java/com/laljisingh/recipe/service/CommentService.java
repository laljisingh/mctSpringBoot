package com.laljisingh.recipe.service;

import com.laljisingh.recipe.model.Comment;
import com.laljisingh.recipe.repository.ComentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    ComentRepository comentRepository;
    public Comment addComment(Comment newComment) {
        Comment save = comentRepository.save(newComment);
        return save;
    }

    public List<Comment> getRecipe() {
        List<Comment> all = comentRepository.findAll();
        return all;
    }

    public void deleteComment(Integer id) {
        comentRepository.deleteById(id);
    }

    public void updateComment(Comment comment1) {
        comentRepository.save(comment1);
    }
}
