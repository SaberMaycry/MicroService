package com.annet.organization.repository;

import com.annet.organization.entity.user.doctor.DoctorUser;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Copyright © 2016 深圳安泰创新科技股份有限公司 版权所有 All Right Reserved
 *
 * @author: Saber
 * 包名：com.annet.organization.repository
 * 时间：2019/10/23 14:16
 * 说明：
 */
public interface DoctorUserRepository extends JpaRepository<DoctorUser, Long> {

}
