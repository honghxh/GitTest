package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.UserRecord;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginUserServiceImp implements LoginUserService {
    @Autowired
    UserRepository2 userRepository2;
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean findUsernameAndPassword(String userName, String passWord) {
        User str = userRepository2.getNameAndPassword(userName, passWord);
        return str != null;
    }

    @Override
    public void adduser(User user) {
        userRepository2.save(user);
    }

    @Override
    public Page<UserRecord> getUserList(int pageNum, int pageSize) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        Page<UserRecord> users = userRepository.findAll(pageable);

        return users;
    }

    public List<UserRecord> findByName(String name) {
        return userRepository.findByNameLike(name);
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
}
