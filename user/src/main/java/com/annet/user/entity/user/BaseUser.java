package com.annet.user.entity.user;

import com.annet.user.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


/**
 * Copyright © 2016 深圳安泰创新科技股份有限公司 版权所有 All Right Reserved
 *
 * @author: Saber
 * 包名：com.annet.user.entity
 * 时间：2019/10/23 11:58
 * 说明：
 */

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "user_base")
public class BaseUser extends BaseEntity {
    // userId唯一编号
    @Column(name = "userId", unique = true, nullable = false)
    private String userId;

    // 密码MD5值
    @Column(name = "password", nullable = false)
    private String password;

    // 密码错误次数
    private Long failNum;
}
