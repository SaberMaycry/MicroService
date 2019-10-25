package com.annet.login.entity.user.doctor;

import com.annet.login.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 医生账单收入记录
 *
 * @author yanhu
 * @date 2018/11/16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tbl_doctor_bill")
public class DoctorBill extends BaseEntity {
    // 医生编号
    private String doctorId;
    // 患者编号
    private String patientId;
    // 就诊人id
    private Long cardId;

    private String patientCardNo;

    // 就诊人姓名
    private String patientCardName;

    // 用途（0在线问诊、网络门诊、1电子处方、2服务包、10提现、20云诊室问诊）
    private Integer useWay;
    // 项目名称
    private String itemName;
    // 账单描述
    private String billMsg;
    // 出入账（0入账，1出账）
    private Integer billWay;

    // 订单类型（0问诊/网络门诊、1电子处方、2服务包、11空中药房处方订单、20诊室问诊订单）
    private Integer orderType;
    // 订单编号
    private String orderCode;
    // 金额
    private Integer money;
    // 账单分类（预留）
    private String billClassify;
    // 账单备注（预留）
    private String billRemark;

    private String department;

    private String orgCode;

    private Integer test;

    public void init() {
        this.test = 0;
    }
}
