package com.andy.springsecurity.repository;

import com.andy.springsecurity.entity.HealthRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author gaojie
 * @Data 2023/1/12 15:52
 */
@Repository
public interface HealthRecordRepository extends JpaRepository<HealthRecord,Integer> {

    List<HealthRecord> getHealthRecordByUsername(String username);
}
