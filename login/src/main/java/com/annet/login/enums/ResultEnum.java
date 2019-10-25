package com.annet.login.enums;

/**
 * Copyright © 2016 深圳安泰创新科技股份有限公司 版权所有 All Right Reserved
 *
 * @author: Saber
 * 包名：com.annet.datarelay.enums
 * 时间：2019/08/02 22:35
 * 说明：返回结果枚举错误信息
 */
public enum ResultEnum {
    /**
     * 返回结果枚错误码和错误信息
     */
    UNKNOW_ERROR(-1, "未知错误！"),
    SUCCESS(0, "成功"),
    PATIENT_INFO_IS_NULL(101, "病人信息为空！"),
    PATIENT_INFO_INPUT_NAME_ERROR(102, "根据就诊卡号查询到患者和输入姓名不一致！"),
    PATIENT_INFO_INPUT_ID_CARD_ERROR(103, "根据就诊卡号查询到患者和输入身份证不一致！"),
    NO_REG_INFO(104, "没有挂号信息！"),
    CARD_NO_IS_NULL(105, "就诊卡号为空！"),
    NAME_IS_NULL(106, "姓名为空！"),
    ID_CARD_IS_NULL(107, "身份证号为空！"),
    PHONE_IS_NULL(108, "手机号为空！"),
    CLINIC_CODE_IS_NULL(109, "门诊号为空！"),
    RECIPE_NO_IS_NULL(110, "处方号为空！"),
    NO_FEE_INFO(111, "没有处方信息！"),
    NO_LIS_INFO(112, "没有检验结果信息！"),
    NO_PACS_INFO(113, "没有检查结果信息！"),
    REG_DATE_IS_NULL(114, "挂号时间为空！"),
    REPORT_DATE_IS_NULL(115, "报告时间为空！"),
    PROCESS_DATE_IS_NULL(116, "处理时间为空！"),
    SAMPLE_ID_IS_NULL(117, "样本号为空！"),
    STUDY_ID_IS_NULL(118, "检查号为空！"),
    CHECK_SERIAL_IS_NULL(119, "检查流水号为空！"),
    REPORT_CARD_NAME_IS_NULL(119, "报告单名称为空！"),
    LIS_SNO_IS_NULL(119, "检查单号为空！"),
    START_DATE_IS_NULL(120, "起始时间为空！"),
    END_DATE_IS_NULL(121, "结束时间为空！"),
    START_DATE_IS_ERROR(122, "起始时间格式错误！"),
    END_DATE_IS_ERROR(123, "结束时间格式错误！"),
    NO_DATA(125, "无数据！"),
    ;

    private int code;
    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}