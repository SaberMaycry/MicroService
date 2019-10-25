package com.annet.organization.utils;

import com.annet.organization.entity.Result;
import com.annet.organization.enums.ResultEnum;

/**
 * Copyright © 2016 深圳安泰创新科技股份有限公司 版权所有 All Right Reserved
 *
 * @author: Saber
 * 包名：com.annet.datarelay.utils
 * 时间：2019/08/02 22:35
 * 说明：返回结果工具类
 */
public class ResultUtil {

    public static boolean isSuccess(Result result) {
        if (result == null) {
            return false;
        }
        return 0 == result.getCode() && "success".equals(result.getError());
    }

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setError("success");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(ResultEnum resultEnum) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setError(resultEnum.getMessage());
        return result;
    }

    public static Result error(int code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setError(message);
        return result;
    }

    public static Result error(Exception ex) {
        Result result = new Result();
        result.setCode(ex.hashCode());
        result.setError(ex.getMessage());
        return result;
    }
}