package com.annet.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.annet.user.entity.Result;
import com.annet.user.service.PatientUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright © 2016 深圳安泰创新科技股份有限公司 版权所有 All Right Reserved
 *
 * @author: Saber
 * 包名：com.annet.user.controller
 * 时间：2019/10/23 14:19
 * 说明：
 */
@RestController
@RequestMapping("/")
public class PatientUserController {
    private PatientUserService patientUserService;

    @Autowired
    public PatientUserController(PatientUserService patientUserService) {
        this.patientUserService = patientUserService;
    }

    @PostMapping(value = "patient")
    public Result addPatientUser(@RequestBody JSONObject node) {
        String name = node.getString("name");
        String idCard = node.getString("idCard");
        return patientUserService.addPatientUser(name, idCard);
    }

    @GetMapping(value = "patient")
    public Result getPatientUser(@RequestBody JSONObject node) {
        String userId = node.getString("userId");
        return patientUserService.getPatientUser(userId);
    }

    @PutMapping(value = "patient")
    public Result updatePatientUser(@RequestBody JSONObject node) {
        String name = node.getString("name");
        String idCard = node.getString("idCard");
        return patientUserService.updatePatientUser(name, idCard);
    }

    @DeleteMapping(value = "patient")
    public Result deletePatientUser(@RequestBody JSONObject node) {
        String userId = node.getString("userId");
        return patientUserService.deletePatientUser(userId);
    }
}
