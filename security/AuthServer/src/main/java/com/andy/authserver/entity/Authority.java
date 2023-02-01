package com.andy.authserver.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Description
 * @Author gaojie
 * @Data 2023/1/12 14:11
 */
@Data
@Entity
public class Authority {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @JoinColumn(name = "user")
    @ManyToOne
    private User user;
}
