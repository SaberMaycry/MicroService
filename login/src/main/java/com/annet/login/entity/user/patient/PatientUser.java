package com.annet.login.entity.user.patient;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Copyright © 2016 深圳安泰创新科技股份有限公司 版权所有 All Right Reserved
 *
 * @author: Saber
 * 包名：com.annet.user.entity
 * 时间：2019/10/23 12:09
 * 说明：
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "user_patient")
public class PatientUser implements Serializable {
    private String name;

    private String parentdept;

    private String dept;

    private String job;

    private String first_hospital;

    private String second_hospital;

    private String hospital_level;

    private String reply;

    private String service_number;

    private String praise;

    @Column(columnDefinition = "TEXT")
    private String good;

    private String price;
}
