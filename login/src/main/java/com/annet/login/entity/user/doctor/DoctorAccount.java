package com.annet.login.entity.user.doctor;

import com.annet.login.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 医生账户信息
 *
 * @author yanhu
 * @version 2019/1/6 11:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tbl_doctor_account")
public class DoctorAccount extends BaseEntity {
    // 医生编号
    @Column(unique = true, nullable = false)
    private String doctorId;

    // 总收入，单位为分
    private Integer totalMoney;

    // 余额
    private Integer balance;

    // 可提款金额
    private Integer usableMoney;

    // 兑换中金额
    private Integer drawings;

    // 已提款金额
    private Integer drawMoney;

    // 户名
    private String accountName;

    // 银行卡号
    private String bankCard;

    // 收款银行
    private String bankName;

    // 医院编号
    private String orgCode;

    public void init() {
        if (null == this.totalMoney) {
            this.totalMoney = 0;
        }
        if (null == this.balance) {
            this.balance = 0;
        }
        if (null == this.usableMoney) {
            this.usableMoney = 0;
        }
        if (null == this.drawings) {
            this.drawings = 0;
        }
        if (null == this.drawMoney) {
            this.drawMoney = 0;
        }
    }
}
