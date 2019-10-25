package com.annet.login.entity.user.doctor;

import com.annet.login.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 医生提款记录
 *
 * @author yanhu
 * @version 2019/1/6 11:54
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tbl_doctor_drawings")
public class DoctorDrawings extends BaseEntity {

    // 医生编号
    private String doctorId;
    // 金额
    private Integer money;
    // 户名
    private String accountName;
    // 银行卡号
    private String bankCard;
    // 收款银行
    private String bankName;
    // 状态（0未审核，1通过，2未通过，3撤销）
    private Integer state;
    // 银行流水单号
    private String bankOrderCode;
    // 提款订单编号
    private String orderCode;

    private String orgCode;
    // 操作人编号
    private String adminId;
    // 操作人姓名
    private String adminName;

    public void init() {
        if (null == this.state) {
            this.state = 0;
        }
    }
}
