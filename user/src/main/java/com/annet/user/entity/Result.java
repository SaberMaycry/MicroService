package com.annet.user.entity;

import lombok.Data;

/**
 * Copyright © 2016 深圳安泰创新科技股份有限公司 版权所有 All Right Reserved
 *
 * @author: Saber
 * 包名：com.annet.datarelay.entity
 * 时间：2019/08/02 22:35
 * 说明：返回结果
 */
@Data
public class Result<T> {
    private int code;
    private String error;
    private T data;
}
