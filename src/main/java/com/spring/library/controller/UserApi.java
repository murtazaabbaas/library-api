package com.spring.library.controller;

import com.spring.library.model.User;
import com.spring.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Murtaza on 2/7/2019.
 */
@RestController
public class UserApi {

    @Autowired
    private UserService userService;

    @GetMapping("/user/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public boolean addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/user/{id}")
    public boolean updateUser(@PathVariable int id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable int id){
        return userService.deleteUser(id);
    }
}
