package com.annet.login.entity.user.doctor;

import com.annet.login.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 医生就诊总览
 *
 * @author yanhu
 * @date 2018/7/25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tbl_doctor_pandect")
public class DoctorPandect extends BaseEntity {

    //医生编号
    @Column(nullable = false)
    private String doctorId;
    //问诊、门诊总量（0+）
    private Integer consultNum;
    //总好评率（0~100）
    private Integer feedback;
    //关注量（0+）
    private Integer attentionNum;
    //问诊、门诊总评论量（0+）
    private Integer commentNum;
    // 退号量（门诊挂号，0+）
    private Integer outRefundAmountNumber;
    // 退单量（在线问诊，0+）
    private Integer conRefundOrderNumber;

    // 总评论量
    @Column(columnDefinition = "int default 0 COMMENT '总评论量'")
    private Integer appraiseNumber;

    public void init() {
        if (null == this.consultNum) {
            this.consultNum = 0;
        }
        if (null == this.feedback) {
            this.feedback = 0;
        }
        if (null == this.attentionNum) {
            this.attentionNum = 0;
        }
        if (null == this.commentNum) {
            this.commentNum = 0;
        }
        if (null == this.outRefundAmountNumber) {
            this.outRefundAmountNumber = 0;
        }
        if (null == this.conRefundOrderNumber) {
            this.conRefundOrderNumber = 0;
        }
    }
}
