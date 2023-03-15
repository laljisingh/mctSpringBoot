package com.laljisingh.recipe.service;

import com.laljisingh.recipe.model.Recipe;
import com.laljisingh.recipe.repository.Reciperepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    @Autowired
    Reciperepository reciperepository;

    public Recipe addRecipe(Recipe newRecipe) {
        Recipe save = reciperepository.save(newRecipe);
        return save;
    }

    public List<Recipe> getRecipe() {
        List<Recipe> all = reciperepository.findAll();
        return all;
    }

    public void deleteRecipe(Integer id) {
        reciperepository.deleteById(id);
    }

    public void updateRecipe(Recipe recipe) {
        reciperepository.save(recipe);
    }
}
