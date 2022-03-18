package com.example.demo.repository;

import com.example.demo.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository1 extends JpaRepository<Admin, Long> {
    @Query(name = "login", nativeQuery = true, value =
            "select * from admin where user_name=:userName and pass_word=:passWord")
    Admin getNameAndPassword(@Param("userName") String username, @Param("passWord") String password);


}

