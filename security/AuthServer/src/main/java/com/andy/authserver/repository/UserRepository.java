package com.andy.authserver.repository;


import com.andy.authserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Description
 * @Author gaojie
 * @Data 2023/1/12 14:56
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findUserByUsername(String username);
}
