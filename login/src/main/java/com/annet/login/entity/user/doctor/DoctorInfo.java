package com.annet.login.entity.user.doctor;

import com.annet.login.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 医生基本信息类
 *
 * @author yanhu
 * @date 2018/6/4
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tbl_doctor_info")
public class DoctorInfo extends BaseEntity {

    //医生编号
    @Column(nullable = false, unique = true)
    private String doctorId;
    //手机号
    private String phone;
    //姓名
    private String name;
    //性别
    private String sex;
    //职称
    private String position;
    //学历
    private String education;
    //科室
    private String department;
    //科室id
    private Long departmentId;
    // 科室编号
    private String departmentCode;
    //医院
    private String hospital;
    //医院编号
    @Column(nullable = false)
    private String orgCode;
    //简介
    @Column(columnDefinition = "text")
    private String introduction;
    //擅长
    @Column(columnDefinition = "text")
    private String speciality;
    //工号
    private String jobNumber;
    //出生日期
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    //头像地址
    private String headImage;
    // 账号停封，删除医生（0可用， 1不可用）
    private Integer stopSeal;
    // 有排班（0无，1有）
    private Integer haveScheduling;
    // APP端userId，用作IM聊天唯一识别
    private String userId;
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
    //是否打开服务（0 未开启，1 开启）,默认0
    private Integer isOpenServe;
    //是否在线（0 不在线，1 在线）,默认0
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

    public void init() {
        if (null == this.stopSeal) {
            this.stopSeal = 0;
        }
        if (null == this.haveScheduling) {
            this.haveScheduling = 0;
        }
        if (null == this.consultFree) {
            this.consultFree = 0;
        }
        if (null == this.isExpert) {
            this.isExpert = 0;
        }
        if (null == this.isRecommend) {
            this.isRecommend = 0;
        }
        if (null == this.subOrgCode) {
            this.subOrgCode = "";
        }
        if (null == this.isOpenServe) {
            this.isOpenServe = 0;
        }
        if (null == this.isOnLine) {
            this.isOnLine = 0;
        }
        if (null == this.position) {
            this.position = "";
        }
        if (null == this.conner) {
            this.conner = 0;
        }
        if (null == this.uploadedIdentity) {
            this.uploadedIdentity = 0;
        }
        if (null == this.generalPractice) {
            this.generalPractice = 0;
        }
        if (null == this.role) {
            this.role = 0;
        }
        if (null == this.extDoctorNo) {
            this.extDoctorNo = "";
        }
        if (null == this.inHospital) {
            this.inHospital = false;
        }
    }
}
