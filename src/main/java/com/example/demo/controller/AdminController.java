package com.example.demo.controller;

import com.example.demo.model.UserRecord;
import com.example.demo.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static java.lang.System.out;

@Controller
public class AdminController {
    @Autowired
    private UserServiceImp userServiceImp;


    @RequestMapping("/")
    public String loginUser(Model model) {

        return "Login";
    }


    //    @RequestMapping("/home-user")
//    public String getAllUser(Model model) {
//        List<UserRecord> Admin = userServiceImp.getAllUsers();
//        model.addAttribute("Admin", Admin);
//        return "HomePage";
//    }
    @RequestMapping("/home-admin")
    public String gerAllUser(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        out.println("============================");
        Page<UserRecord> users = userServiceImp.getUserList(pageNum, pageSize);
//        out.println("总页数" + users.getTotalPages());
//        out.println("当前页是：" + pageNum);
//        out.println("分页数据：");
//        for (UserRecord user : users) {
//            out.println(user.toString());
//        }
        model.addAttribute("users", users);


        return "HomePage";
    }

    @RequestMapping(value = "/add-admin", method = RequestMethod.POST)
    public String addUser(@ModelAttribute UserRecord userRecord) {
        userServiceImp.addUser(userRecord);
//redirect重定向
        return "redirect:/home-admin";

    }

    @RequestMapping(value = "/new-admin", method = RequestMethod.GET)
    public String newUser(Model model) {
        UserRecord userRecord = new UserRecord();
        model.addAttribute("userRecord", userRecord);
        return "AddPage";
    }
//restful风格
    @RequestMapping(value = "/del-admin/{id}", method = RequestMethod.GET)
    public String delUser(@PathVariable Long id) {
        userServiceImp.deleteById(id);
        return "redirect:/home-admin";
    }


    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public String find(Model model) {
//
        return "find";
    }

    @RequestMapping(value = "/find-admin", method = RequestMethod.GET)
    public String findUser(Model model, @RequestParam("id") Long id, Map<String, Object> map) {
        try {
            UserRecord userRecord = userServiceImp.finduser(id);
            model.addAttribute("userRecord", userRecord);
            return "findPage";
        } catch (Exception RuntimeException) {
            out.println("错误 该用户不存在");
            map.put("Msg", "该用户不存在请重新查询");
            return "find";
        }

    }

    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    public String findByName(Model model, @RequestParam("name") String name, Map<String, Object> map) {
        try {
            List<UserRecord> userRecord = userServiceImp.findByName("%"+name+"%");
            model.addAttribute("userRecord", userRecord);
            return "findPage";
        } catch (Exception RuntimeException) {
            out.println("错误 该用户不存在");
            map.put("Msg", "该用户不存在请重新查询");
            return "find";
        }

    }

    @RequestMapping(value = "/update-admin/{id}", method = RequestMethod.GET)
    public String updateUser(@PathVariable Long id, Model model) {
        UserRecord userRecord = userServiceImp.getUserRecordById(id);
        model.addAttribute("userRecord", userRecord);
        return "UpdatePage";
    }


}