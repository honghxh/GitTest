package com.example.demo.service;

import com.example.demo.model.UserRecord;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    public List<UserRecord> getAllUsers();

    public void deleteById(Long id);

    public void deleteuser(UserRecord userRecord);

    public void addUser(UserRecord userRecord);

    public UserRecord finduser(Long id);

    public UserRecord getUserRecordById(Long id);

    Page<UserRecord> getUserList(int pageNum, int pageSize);

    public List<UserRecord> findByName(String name);
}

