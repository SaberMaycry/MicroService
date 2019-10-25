package com.annet.organization.service;

import com.annet.organization.entity.Result;
import com.annet.organization.repository.PatientUserRepository;
import com.annet.organization.utils.ResultUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright © 2016 深圳安泰创新科技股份有限公司 版权所有 All Right Reserved
 *
 * @author: Saber
 * 包名：com.annet.organization.service
 * 时间：2019/10/23 14:18
 * 说明：
 */
@Service
public class PatientUserService {
    private PatientUserRepository patientUserRepository;

    @Autowired
    public PatientUserService(PatientUserRepository patientUserRepository) {
        this.patientUserRepository = patientUserRepository;
    }

    public Result addPatientUser(String name, String idCard) {
        return ResultUtil.success();
    }

    public Result getPatientUser(String userId) {
        return ResultUtil.success();
    }

    public Result updatePatientUser(String name, String idCard) {
        return ResultUtil.success();
    }

    public Result deletePatientUser(String userId) {
        return ResultUtil.success();
    }
}
