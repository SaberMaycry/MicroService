package com.annet.user.entity.user.patient;

import com.annet.user.entity.BaseEntity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Copyright © 2016 深圳安泰创新科技股份有限公司 版权所有 All Right Reserved
 *
 * @author: Saber
 * 包名：com.annet.user.entity
 * 时间：2019/10/23 12:09
 * 说明：
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "user_patient")
public class PatientUser extends BaseEntity implements Serializable {
    // 用户唯一标识，userId
    private String userId;

    // 姓名
    private String name;

    // 性别
    private String gender;

    // 身份证
    private String idCard;
}
