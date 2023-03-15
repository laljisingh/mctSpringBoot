package com.laljisingh.recipe.service;

import com.laljisingh.recipe.model.User;
import com.laljisingh.recipe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public User addUser(User newUser) {
        User save = userRepository.save(newUser);
        return save;
    }

    public List<User> getAllUser() {
        List<User> all = userRepository.findAll();
        return all;
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }


    public String updateUser(Integer id, User updatedUser) {
        User user = null;
        user = userRepository.findById(id).get();
        if(null != user){
            return "found";
        }else{
            return "User Not Found";
        }
    }
}
