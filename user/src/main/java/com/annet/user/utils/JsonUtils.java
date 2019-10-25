package com.annet.user.utils;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * Copyright © 2016 深圳安泰创新科技股份有限公司 版权所有 All Right Reserved
 *
 * @author: Saber
 * 包名：com.annet.datarelay.utils
 * 时间：2019/08/02 22:35
 * 说明：Json字符串工具类
 */
public class JsonUtils {

    public static <T> List<T> parseArrayFromUS7ASCII(Object object, Class<T> clazz) {
        String jsonString = JSON.toJSONString(object);
        String str = StrUtils.us7asciiToStr(jsonString);

        return JSON.parseArray(str, clazz);

    }

    public static <T> T parseFromUS7ASCII(Object object, Class<T> clazz) {
        String jsonString = JSON.toJSONString(object);
        String str = StrUtils.us7asciiToStr(jsonString);

        return JSON.parseObject(str, clazz);
    }
}
