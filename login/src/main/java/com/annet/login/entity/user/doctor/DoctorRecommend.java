package com.annet.login.entity.user.doctor;

import com.annet.login.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 推荐医生
 *
 * @author yanhu
 * @version 2019/1/6 14:56
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tbl_doctor_recommend")
public class DoctorRecommend extends BaseEntity {

    // 科室
    private String department;
    // 医生编号
    private String doctorId;
    // 排序号
    private Integer serialNum;

    private String orgCode;

}
