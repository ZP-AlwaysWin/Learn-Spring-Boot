package com.example.springbootransaction.service;


import com.example.springbootransaction.dao.User;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

    @Transactional
    User login(String name, String password);

}