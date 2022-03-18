package com.example.demo.service;

import com.example.demo.model.UserRecord;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<UserRecord> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(UserRecord userRecord) {
        userRepository.save(userRecord);
    }

    @Override
    public void deleteuser(UserRecord userRecord) {
        userRepository.delete(userRecord);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserRecord finduser(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public UserRecord getUserRecordById(Long id) {
        Optional<UserRecord> byId = userRepository.findById(id);
        UserRecord userRecord = null;
        if (byId.isPresent()) {
            userRecord = byId.get();
        } else {
            throw new RuntimeException("该id不存在");
        }
        return userRecord;
    }

    @Override
    public Page<UserRecord> getUserList(int pageNum, int pageSize) {
            Sort sort = Sort.by(Sort.Direction.DESC, "id");
            Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
            Page<UserRecord> users = userRepository.findAll(pageable);

            return users;
        }
        @Override
    public List<UserRecord> findByName(String name){
            return userRepository.findByNameLike(name);
        }
    }


