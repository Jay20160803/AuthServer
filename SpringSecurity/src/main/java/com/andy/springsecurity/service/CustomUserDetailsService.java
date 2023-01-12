package com.andy.springsecurity.service;

import com.andy.springsecurity.service.CustomUserDetails;
import com.andy.springsecurity.entity.User;
import com.andy.springsecurity.exception.UsernameNotFoundException;
import com.andy.springsecurity.repository.UserRepository;
import com.andy.springsecurity.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Description
 * @Author gaojie
 * @Data 2023/1/12 14:58
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) {
        Optional<User> optional = userRepository.findUserByUsername(username);
        if(optional.isPresent()){
            return new CustomUserDetails(optional.get());
        }

        throw new UsernameNotFoundException("Username " + username + " is invalid!");
    }
}
