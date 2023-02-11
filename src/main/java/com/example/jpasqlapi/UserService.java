package com.example.jpasqlapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public String addUser(UserEntity userEntity) {
        userRepository.save(userEntity);
        return "User Added Succesfully.";

        //http://localhost:8080/user/add
//        {
//            "id":5,
//                "name":"fghhfshs",
//                "age":22
//        }
    }

    public UserEntity getUserById(int id) {
        UserEntity user = userRepository.findById(id).get();//find the entity by primary key
        return user;
    }

    public UserEntity getUser(int id){

        UserEntity user = userRepository.findById(id).get(); //Help you find the Entity by primary key.

        return user;
    }

    public List<UserEntity> getAllUser(){
        List<UserEntity> user = userRepository.findAll();
        return user;
    }
}
