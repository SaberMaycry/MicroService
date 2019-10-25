package com.annet.login.entity.user.doctor;

import com.annet.login.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 医生实名认证
 *
 * @author yanhu
 * @date 2018/11/5
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tbl_doctor_identify")
public class DoctorIdentify extends BaseEntity {

    // 医生编号
    private String doctorId;
    // 真实姓名
    private String name;
    // 身份证号
    private String idCard;
    // 身份证正面照url
    private String idCardFront;
    // 身份证反面照url
    private String idCardVerso;
    // 医生资格证url
    private String licence;
    // 医生执业证url
    private String practicing;
    // 认证状态（0未认证，1认证成功，2认证失败）
    private Integer state;
    // 医院编号
    private String orgCode;
    // 是否测试（0否，1是）
    private Integer test;


    // 专业技术职务代码
    private String professionalTechnicalJobCode;
    // 专业技术职务类别代码
    private String professionalTechnicalJobCategoryCode;
    // 资质类别名称
    private String qualificationCategoryName;
    // 资格证书编号
    private String qualificationCertificateNumber;
    // 资格获得时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate qualificationTime;
    // 执业证书编码
    private String practiceCertificateCode;
    // 发证日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfIssue;
    // 执业地点
    private String placeOfPractice;
    // 执业范围
    private String practiceScope;
    // 主要执业医疗机构代码
    private String mainPracticeMedicalInstitutionCode;
    // 主要执业医院名称
    private String mainPracticeHospitalName;
    // 全科医生标志
    private String generalPractitionerMark;
    // 手机号
    private String phone;
    // 参加工作日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate participationDate;
    // 注册时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registrationTime;
    // 个人照片url
    private String personalPhotosUrl;

    public void init() {
        if (null == this.state) {
            this.state = 0;
        }
        if (null == this.test) {
            this.test = 0;
        }
    }
}
