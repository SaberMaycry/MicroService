package com.annet.user.entity.user.doctor;

import com.annet.user.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class DoctorUser extends BaseEntity implements Serializable {

    // 用户唯一标识，userId，APP端userId，用作IM聊天唯一识别
    @Column(nullable = false, unique = true)
    private String userId;

    // 姓名
    private String name;

    // 性别
    private String gender;

    // 身份证
    private String idCard;

    // 医生编号
    @Column(nullable = false, unique = true)
    private String doctorId;

    // 手机号
    private String phone;

    // 职称
    private String jobTitle;

    // 学历
    private String education;

    // 科室
    private String deptName;

    // 科室编码
    private String deptCode;

    // 医院
    private String orgName;

    // 医院编号
    @Column(nullable = false)
    private String orgCode;

    // 简介
    @Column(columnDefinition = "text")
    private String introduction;

    // 擅长
    @Column(columnDefinition = "text")
    private String goodAt;

    // 工号
    private String jobNo;

    // 出生日期
    private String birthday;

    // 头像地址
    private String headImage;

    // 账号停封，删除医生（0可用， 1不可用）
    private Integer stopSeal;

    // 有排班（0无，1有）
    private Integer haveScheduling;
    // APP端userId，用作IM聊天唯一识别

    // 医生二维码url
    private String qrCode;

    // 是否实名认证（0否，1是）
    private Integer isIdentify;

    // 问诊免费（0不免费，1免费）
    private Integer consultFree;

    // 院区
    private String hospitalArea;

    // 小程序openId
    @JsonIgnore
    private String openId;

    // 是否推荐医生（0否，1是）
    private Integer isRecommend;

    // 子医院、院区
    private String subOrgCode;

    // 是否打开服务（0 未开启，1 开启）,默认0
    private Integer isOpenServe;

    // 是否在线（0 不在线，1 在线）,默认0
    private Integer isOnLine;

    // 是否测试医生（0否，1是）
    private Integer conner;

    // 是否已经上传实名认证附件（0否，1是）
    private Integer uploadedIdentity;

    // 是否名医专家（0否，1是）
    private Integer isExpert;

    // 医生角色（0 正常医生；1 医生助理）
    private Integer role;

    // 是否全科医生（0否，1是）
    private Integer generalPractice;

    // 小程序是否在线
    private Boolean online;

    // 医院医生编号
    private String extDoctorNo;

    // 是否院内真实医生
    private Boolean inHospital;
}
