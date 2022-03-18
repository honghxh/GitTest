package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginServiceImp implements loginService {
    @Autowired
    private UserRepository1 userRepository1;

    @Override
    public boolean findUsernameAndPassword(String userName, String passWord) {
        Admin str =  userRepository1.getNameAndPassword(userName,passWord);
        return str != null;
    }
}
