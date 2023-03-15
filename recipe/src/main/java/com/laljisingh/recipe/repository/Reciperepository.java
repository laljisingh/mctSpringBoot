package com.laljisingh.recipe.repository;

import com.laljisingh.recipe.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Reciperepository extends JpaRepository<Recipe, Integer> {
}
