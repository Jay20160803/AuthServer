package com.andy.authserver.entity;

import com.andy.authserver.enums.PasswordEncoderType;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @Description
 * @Author gaojie
 * @Data 2023/1/12 14:01
 */
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private PasswordEncoderType passwordEncoderType;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Authority> authorities;
}
