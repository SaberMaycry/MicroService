package com.annet.login.entity.user.doctor;

import com.annet.login.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 医生收藏患者表
 *
 * @author yanhu
 * @date 2018/7/25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tbl_doctor_collect")
public class DoctorCollect extends BaseEntity {

    //医生编号
    @Column(nullable = false)
    private String doctorId;

    //患者编号
    @Column(nullable = false)
    private String patientId;

    //就诊人id
    private Long cardId;

    private String patientCardNo;

}
