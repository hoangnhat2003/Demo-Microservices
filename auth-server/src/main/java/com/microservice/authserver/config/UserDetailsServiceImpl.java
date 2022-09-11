package com.microservice.authserver.config;

import com.microservice.authserver.domain.document.User;
import com.microservice.authserver.domain.exception.AuthExceptionHandling;
import com.microservice.authserver.domain.repository.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    UserRepository userRepository;

    @Override
    @SneakyThrows
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null)
            throw new AuthExceptionHandling("Email has not been registered");
        return UserDetailsImpl.build(user);
    }
}