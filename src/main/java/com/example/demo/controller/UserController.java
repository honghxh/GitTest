package com.example.demo.controller;

import com.example.demo.model.UserRecord;
import com.example.demo.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static java.lang.System.out;

@Controller
public class UserController {
    @Autowired
    private UserServiceImp userServiceImp;

    @RequestMapping("/home-user")
    public String gerAllUser(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        out.println("============================");
        Page<UserRecord> users = userServiceImp.getUserList(pageNum, pageSize);

        model.addAttribute("users", users);


        return "UserHomePage";
    }
}
