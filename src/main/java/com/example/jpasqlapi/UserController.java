package com.example.jpasqlapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserEntity userEntity){
        String addMsg = userService.addUser(userEntity);
        return new ResponseEntity<>(addMsg, HttpStatus.CREATED);
    }

    @GetMapping("/get-by-id")
    public ResponseEntity<UserEntity> getUserById(@RequestParam("id")Integer id){
        UserEntity user = userService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
    }

    @GetMapping("/getUser")
    public UserEntity getUser(@RequestParam("id")Integer id){

        return userService.getUser(id);
    }
    @GetMapping("/getAllUser")
    public List<UserEntity> getAllUser(){
        return userService.getAllUser();
    }
}
