package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.UserRecord;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LoginUserService {
    public boolean findUsernameAndPassword(String userName, String passWord);

    void adduser(User user);

    Page<UserRecord> getUserList(int pageNum, int pageSize);

    public List<UserRecord> findByName(String name);

    public UserRecord finduser(Long id);

    public UserRecord getUserRecordById(Long id);
}
