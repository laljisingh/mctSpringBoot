package com.laljisingh.recipe.controller;

import com.laljisingh.recipe.model.Recipe;
import com.laljisingh.recipe.model.User;
import com.laljisingh.recipe.repository.Reciperepository;
import com.laljisingh.recipe.repository.UserRepository;
import com.laljisingh.recipe.service.RecipeService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class RecipeController {
    @Autowired
    RecipeService recipeService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    Reciperepository reciperepository;
    @PostMapping("/add-recipe")
    public ResponseEntity addRecipe(@Valid @RequestBody Recipe newRecipe){
        Recipe recipe = recipeService.addRecipe(newRecipe);
        return new ResponseEntity<>("Recipe added woth id - "+recipe.getRecipe_id(), HttpStatus.ACCEPTED);
    }
    @GetMapping("/get-recipe")
    public ResponseEntity<List<Recipe>> getRecipe(){
        List<Recipe> recipe = recipeService.getRecipe();
        return new ResponseEntity<>(recipe, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delet-recipe/{id}")
    public ResponseEntity<String> DeleteRecipe(@PathVariable Integer id){
        recipeService.deleteRecipe(id);
        return new ResponseEntity<>("Recipe deleted", HttpStatus.ACCEPTED);
    }
    @PutMapping("/update-recipe/{id}")
    public ResponseEntity<String> updaterecipe(@PathVariable Integer id, @RequestBody String updatedRecipe){
        JSONObject json= new JSONObject(updatedRecipe);
        Recipe recipe = setRecipe(json, id);
        recipeService.updateRecipe(recipe);
        return new ResponseEntity<>("Recipe Updated Suceuss",HttpStatus.ACCEPTED);
    }

    private Recipe setRecipe(JSONObject json, Integer id) {
        Recipe rcp = reciperepository.findById(id).get();
        rcp.setIngredients(json.getString("ingredients"));
        rcp.setRecipe_name(json.getString("name"));
        rcp.setInstruction(json.getString("instruction"));
        int userId = json.getInt("userId");
        User user = userRepository.findById(userId).get();
        rcp.setUser_id(user);
        return rcp;
    }


}
