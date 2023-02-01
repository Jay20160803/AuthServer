package com.andy.springsecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author gaojie
 * @Data 2023/1/12 16:34
 */
@RestController
public class UserController {


    @GetMapping("/userInfo")
    public Authentication userInfo(Authentication authentication){
        return authentication;
    }

}
