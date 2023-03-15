package com.laljisingh.recipe.repository;

import com.laljisingh.recipe.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentRepository extends JpaRepository<Comment, Integer> {
}
