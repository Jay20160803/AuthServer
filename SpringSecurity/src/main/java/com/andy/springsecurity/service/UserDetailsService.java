package com.andy.springsecurity.service;

/**
 * @Description
 * @Author gaojie
 * @Data 2023/1/12 14:59
 */
public interface UserDetailsService {

    CustomUserDetails loadUserByUsername(String username);
}
