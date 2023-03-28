package com.laljisingh.recipe.controller;

import com.laljisingh.recipe.model.User;
import com.laljisingh.recipe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;






    @PostMapping("/add-user")
    public ResponseEntity<String> addUser(@RequestBody User newUser){

        User user = userService.addUser(newUser);
        return new ResponseEntity<>("User saved with id:-", HttpStatus.CREATED);
    }
    @GetMapping("/get-all-user")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = userService.getAllUser();
        return new ResponseEntity<>(allUser, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return new ResponseEntity<>("User Deleted", HttpStatus.ACCEPTED);
    }
    @PutMapping("/update-user/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody User updatedUser){
        String s = userService.updateUser(id, updatedUser);
        return new ResponseEntity<>(s, HttpStatus.ACCEPTED);
    }


}
