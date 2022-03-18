package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.LoginUserServiceImp;
import com.example.demo.service.loginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    loginServiceImp loginService1;
    @Autowired
    LoginUserServiceImp loginUserServiceImp;

    @RequestMapping(value = "/login-admin", method = RequestMethod.POST)
    public String loginAdmin(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             Map<String, Object> map,
                             HttpSession session) {
        if (loginService1.findUsernameAndPassword(username, password)) {
            session.setAttribute("loginUser", username);
            return "redirect:/home-admin";
        } else {
            map.put("loginMsg", "账户密码错误请重新输入");
            return "/Login";
        }
    }


    @RequestMapping(value = "/login-user", method = RequestMethod.POST)
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            Map<String, Object> map,
                            HttpSession session) {
        if (loginUserServiceImp.findUsernameAndPassword(username, password)) {
            session.setAttribute("loginUser", username);
            return "redirect:/home-user";
        } else {
            map.put("loginMsg", "账户密码错误请重新输入");
            return "/Login";
        }
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }


    @RequestMapping(value = "loginU", method = RequestMethod.GET)
    public String loginUser(Model model) {

        return "loginUser";
    }

    @RequestMapping(value = "loginA", method = RequestMethod.GET)
    public String loginAdmin(Model model) {

        return "loginAdmin";
    }


    @PostMapping(value = "/register-user")
    public String register(@ModelAttribute User user) {
        loginUserServiceImp.adduser(user);
        return "redirect:/";
    }

}
