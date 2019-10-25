package com.annet.login.entity.user.doctor;

import com.annet.login.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 医生排班
 *
 * @author yanhu
 * @date 2018/10/18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tbl_doctor_scheduling")
public class DoctorScheduling extends BaseEntity {

    // 排班日期
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    private Date dateShift;
    // 当天时间段 08:00-12:00
    private String timeSlot;

    // 医生编号
    private String doctorId;
    // 医生姓名
    private String name;
    // 上午、下午
    private String daySlot;
    // 当前排班挂号人数
    private Integer regNum;
    // 当天是否不能执行（默认0可以执行，1不能执行），针对突发情况，医生无法正常工作。
    private Integer cannotExecute;

    // 排班日期（yyyy-MM-dd）
    private String date;
    // 开始时间（HH:mm）
    private String startTime;
    // 结束时间（HH:mm）
    private String endTime;
    // 最大挂号量
    private Integer maxCount;
    // 挂号价格
    private Integer price;
    // 折扣价格（-1表示无折扣）
    private Integer discPrice;
    // 是否启用（0未启用，1已启用）
    private Integer startUsing;
    // 科室
    private String department;
    // 医生工号
    private String jobNum;

    private String orgCode;

    private String subOrgCode;
}
