package com.annet.login.entity.user.doctor;

import com.annet.login.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 医生常用回复
 *
 * @author yanhu
 * @date 2018/7/25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tbl_doctor_reply")
public class DoctorReply extends BaseEntity {

    //医生编号
    @Column(nullable = false)
    private String doctorId;
    //内容
    @Column(columnDefinition = "text")
    private String content;
}
