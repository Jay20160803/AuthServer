package com.andy.springsecurity.controller;

import com.andy.springsecurity.service.HealthRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description
 * @Author gaojie
 * @Data 2023/1/12 15:43
 */
@Controller
public class IndexController {

    @Autowired
    private HealthRecordService healthRecordService;

    @GetMapping("/index")
    public String index(Authentication authentication, Model model){
        model.addAttribute("username",authentication.getName());
        model.addAttribute("healthRecords",healthRecordService.getHealthRecordByUsername(authentication.getName()));
        return "index.html";
    }

}
