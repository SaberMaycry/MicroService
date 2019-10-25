package com.annet.user.service;

import com.annet.user.entity.Result;
import com.annet.user.repository.DoctorUserRepository;
import com.annet.user.utils.ResultUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright © 2016 深圳安泰创新科技股份有限公司 版权所有 All Right Reserved
 *
 * @author: Saber
 * 包名：com.annet.user.service
 * 时间：2019/10/23 14:17
 * 说明：
 */
@Service
public class DoctorUserService {
    private DoctorUserRepository doctorUserRepository;

    @Autowired
    public DoctorUserService(DoctorUserRepository doctorUserRepository) {
        this.doctorUserRepository = doctorUserRepository;
    }

    public Result addDoctorUser(String name, String idCard) {
        return ResultUtil.success();
    }

    public Result getDoctorUser(String userId) {
        return ResultUtil.success();
    }

    public Result updateDoctorUser(String name, String idCard) {
        return ResultUtil.success();
    }

    public Result deleteDoctorUser(String userId) {
        return ResultUtil.success();
    }
}
