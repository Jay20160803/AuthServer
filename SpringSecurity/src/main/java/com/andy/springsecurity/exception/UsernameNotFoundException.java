package com.andy.springsecurity.exception;

/**
 * @Description
 * @Author gaojie
 * @Data 2023/1/12 15:02
 */
public class UsernameNotFoundException extends RuntimeException{

    public UsernameNotFoundException(String message){
        super(message);
    }
}
