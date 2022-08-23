package com.microservice.customerservice.service;

import com.microservice.customerservice.entity.User;
import com.microservice.customerservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
      return null;
    }
}
