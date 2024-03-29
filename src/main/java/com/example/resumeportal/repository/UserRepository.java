package com.example.resumeportal.repository;

import com.example.resumeportal.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface   UserRepository extends JpaRepository<MyUser, Integer> {

    Optional<MyUser> findByUserName(String userName);
}
