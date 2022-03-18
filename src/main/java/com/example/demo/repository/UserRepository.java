package com.example.demo.repository;

import com.example.demo.model.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserRecord, Long> {
    List<UserRecord> findByNameLike(String name);
}
