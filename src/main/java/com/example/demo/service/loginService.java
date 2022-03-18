package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.model.User;

public interface loginService {

    public boolean findUsernameAndPassword(String userName,String passWord);

}
