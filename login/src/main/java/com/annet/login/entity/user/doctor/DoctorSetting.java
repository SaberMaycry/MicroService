package com.annet.login.entity.user.doctor;

import com.annet.login.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 医生配置类
 *
 * @author yanhu
 * @date 2018/7/25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tbl_doctor_setting")
public class DoctorSetting extends BaseEntity {

    //医生编号
    @Column(nullable = false)
    private String doctorId;
    //图文服务价格，单位为分（-1 暂无此服务，0+ 服务价格）
    private Integer imageTextPrice;
    //电话服务价格，单位为分（-1 暂无此服务，0+ 服务价格）
    private Integer phonePrice;
    //视频服务价格，单位为分（-1 暂无此服务，0+ 服务价格）
    private Integer videoPrice;

    // 在线问诊价格，单位为分（0+服务价格）
    private Integer consultPrice;
    // 网络门诊价格，单位为分（0+ 服务价格）
    private Integer outpatientPrice;

    //图文服务促销价，单位为分（0无促销，1+促销服务价格）
    private Integer expandTextPrice;
    //电话服务促销价，单位为分（0无促销，1+促销服务价格）
    private Integer expandPhonePrice;
    //视频服务促销价，单位为分（0无促销，1+促销服务价格）
    private Integer expandVideoPrice;

    // 在线问诊促销价格，单位为分（0无促销，1+促销服务价格）
    private Integer expandConsultPrice;
    // 网络门诊价格促销价，单位为分（0无促销，1+促销服务价格）
    private Integer expandOutpatientPrice;

    // 咨询开始时间（09:00）
    private String consultStartTime;
    // 咨询结束时间（18:00）
    private String consultEndTime;

    // 药品处方解读价格，单位为分（-1 暂无此服务，0+ 服务价格）
    private Integer drugRecipeUnscramblePrice;

    // 检查、检验报告解读价格，单位为分（-1 暂无此服务，0+ 服务价格）
    private Integer reportUnscramblePrice;

    // 外部挂号费用
    private Integer extRegistrationFee;

    public void init() {
        if (null == this.imageTextPrice) {
            this.imageTextPrice = -1;
        }
        if (null == this.phonePrice) {
            this.phonePrice = -1;
        }
        if (null == this.videoPrice) {
            this.videoPrice = -1;
        }
        if (null == this.consultPrice) {
            this.consultPrice = -1;
        }
        if (null == this.outpatientPrice) {
            this.outpatientPrice = 0;
        }

        if (null == this.expandTextPrice) {
            this.expandTextPrice = 0;
        }
        if (null == this.expandPhonePrice) {
            this.expandPhonePrice = 0;
        }
        if (null == this.expandVideoPrice) {
            this.expandVideoPrice = 0;
        }
        if (null == this.expandConsultPrice) {
            this.expandConsultPrice = 0;
        }
        if (null == this.expandOutpatientPrice) {
            this.expandOutpatientPrice = 0;
        }
        if (null == this.drugRecipeUnscramblePrice) {
            this.drugRecipeUnscramblePrice = 0;
        }
        if (null == this.reportUnscramblePrice) {
            this.reportUnscramblePrice = 0;
        }
        if (null == this.extRegistrationFee) {
            this.extRegistrationFee = 0;
        }
    }
}
