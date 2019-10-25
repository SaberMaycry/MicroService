package com.annet.user.repository;

import com.annet.user.entity.user.doctor.DoctorUser;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Copyright © 2016 深圳安泰创新科技股份有限公司 版权所有 All Right Reserved
 *
 * @author: Saber
 * 包名：com.annet.user.repository
 * 时间：2019/10/23 14:16
 * 说明：
 */
public interface PatientUserRepository extends JpaRepository<DoctorUser, Long> {

}
