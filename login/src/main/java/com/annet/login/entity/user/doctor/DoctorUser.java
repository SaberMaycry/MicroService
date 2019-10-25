package com.annet.login.entity.user.doctor;

import com.annet.login.entity.user.BaseUser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Copyright © 2016 深圳安泰创新科技股份有限公司 版权所有 All Right Reserved
 *
 * @author: Saber
 * 包名：com.annet.user.entity
 * 时间：2019/10/23 12:08
 * 说明：
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "user_doctor")
public class DoctorUser extends BaseUser {
    private String name;

    private String parentdept;

    private String dept;

    private String job;

    private String first_hospital;

    private String second_hospital;

    private String hospital_level;

    @Column(columnDefinition = "TEXT")
    private String good;

    private String price;
}
