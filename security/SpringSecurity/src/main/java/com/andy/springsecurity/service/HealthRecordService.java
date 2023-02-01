package com.andy.springsecurity.service;

import com.andy.springsecurity.entity.HealthRecord;
import com.andy.springsecurity.repository.HealthRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author gaojie
 * @Data 2023/1/12 16:00
 */
@Service
public class HealthRecordService {

    @Autowired
    private HealthRecordRepository healthRecordRepository;

    public List<HealthRecord> getHealthRecordByUsername(String username){
        return healthRecordRepository.getHealthRecordByUsername(username);
    }
}
