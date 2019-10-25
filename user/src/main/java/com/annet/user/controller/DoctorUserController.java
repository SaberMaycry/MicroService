package com.annet.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.annet.user.entity.Result;
import com.annet.user.service.DoctorUserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * Copyright © 2016 深圳安泰创新科技股份有限公司 版权所有 All Right Reserved
 *
 * @author: Saber
 * 包名：com.annet.user.controller
 * 时间：2019/10/23 14:14
 * 说明：
 */
@RestController
@RequestMapping("/")
@Slf4j
public class DoctorUserController {
    private DoctorUserService doctorUserService;

    public DoctorUserController(DoctorUserService doctorUserService) {
        this.doctorUserService = doctorUserService;
    }

    @PostMapping(value = "doctor")
    public Result addDoctorUser(@RequestBody JSONObject node) {
        String name = node.getString("name");
        String idCard = node.getString("idCard");
        return doctorUserService.addDoctorUser(name, idCard);
    }

    @GetMapping(value = "doctor")
    public Result getPatientUser(@RequestBody JSONObject node) {
        String userId = node.getString("userId");
        return doctorUserService.getDoctorUser(userId);
    }

    @PutMapping(value = "doctor")
    public Result updatePatientUser(@RequestBody JSONObject node) {
        String name = node.getString("name");
        String idCard = node.getString("idCard");
        return doctorUserService.updateDoctorUser(name, idCard);
    }

    @DeleteMapping(value = "doctor")
    public Result deletePatientUser(@RequestBody JSONObject node) {
        String userId = node.getString("userId");
        return doctorUserService.deleteDoctorUser(userId);
    }
}
