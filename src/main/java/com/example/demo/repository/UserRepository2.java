package com.example.demo.repository;

import com.example.demo.model.Admin;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


    public interface UserRepository2 extends JpaRepository<User, Long> {
        @Query(name = "login", nativeQuery = true, value =
                "select * from user where user_name=:userName and pass_word=:passWord")
        User getNameAndPassword(@Param("userName") String username, @Param("passWord") String password);


    }

