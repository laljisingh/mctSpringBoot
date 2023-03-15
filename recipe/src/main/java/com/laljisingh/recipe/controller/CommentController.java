package com.laljisingh.recipe.controller;

import com.laljisingh.recipe.model.Comment;
import com.laljisingh.recipe.model.Recipe;
import com.laljisingh.recipe.model.User;
import com.laljisingh.recipe.repository.ComentRepository;
import com.laljisingh.recipe.repository.Reciperepository;
import com.laljisingh.recipe.repository.UserRepository;
import com.laljisingh.recipe.service.CommentService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CommentController {
    @Autowired
    ComentRepository comentRepository;
    @Autowired
    CommentService commentService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    Reciperepository reciperepository;

    @PostMapping("/add-comment")
    public ResponseEntity<String> addComment(@RequestBody String newComment) {
        JSONObject json = new JSONObject(newComment);
        Comment comment1 = validateComment(json);
        Comment comment = commentService.addComment(comment1);
        return new ResponseEntity<String>("saved with id - "+comment.getComment_id(), HttpStatus.ACCEPTED);
    }

    private Comment validateComment(JSONObject json) {
        Comment cmt=new Comment();
        cmt.setComment(json.getString("comment"));
        int userId = json.getInt("userId");
        int recipeId = json.getInt("recipeId");
        //user addition
        List<User> userid = new ArrayList<>();
        User usr=null;
        usr = userRepository.findById(userId).get();
        userid.add(usr);
        cmt.setUserList(userid);
        // recipe addigng
        List<Recipe> recipe = new ArrayList<>();
        Recipe rcp=null;
        rcp = reciperepository.findById(recipeId).get();
        recipe.add(rcp);
        cmt.setReciepList(recipe);
        return  cmt;
    }


    @GetMapping("/get-comment")
    public ResponseEntity<List<Comment>> getComment(){
        List<Comment> comment = commentService.getRecipe();
        return new ResponseEntity<>(comment, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delet-comment/{id}")
    public ResponseEntity<String> DeleteComment(@PathVariable Integer id){
        commentService.deleteComment(id);
        return new ResponseEntity<>("Comment deleted", HttpStatus.ACCEPTED);
    }
    @PutMapping("/update-comment/{id}")
    public ResponseEntity<String> updatePostAnyUser(@PathVariable Integer id,@RequestBody String updateComment){
        JSONObject json = new JSONObject(updateComment);
        Comment comment1 = setComment(json, id);
        commentService.updateComment(comment1);
        return new ResponseEntity<>("User Updated Succefully", HttpStatus.ACCEPTED);
    }

    private Comment setComment(JSONObject json, Integer id) {
        Comment cmt = comentRepository.findById(id).get();
        cmt.setComment(json.getString("comment"));
        int userId = json.getInt("userId");
        int recipeId = json.getInt("recipeId");
        //user addition
        List<User> userid = new ArrayList<>();
        User usr=null;
        usr = userRepository.findById(userId).get();
        userid.add(usr);
        cmt.setUserList(userid);
        // recipe addigng
        List<Recipe> recipe = new ArrayList<>();
        Recipe rcp=null;
        rcp = reciperepository.findById(recipeId).get();
        recipe.add(rcp);
        cmt.setReciepList(recipe);
        return cmt;
    }


}
