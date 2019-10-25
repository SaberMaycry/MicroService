package com.annet.login.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Copyright © 2016 深圳安泰创新科技股份有限公司 版权所有 All Right Reserved
 *
 * @author: Saber
 * 包名：com.annet.datarelay.utils
 * 时间：2019/08/09 00:49
 * 说明：排序工具类
 */
public class SortUtils {
    public static <K extends Comparable<? super K>, V> Map<K, V> sortByKey(Map<K, V> map) {
        Map<K, V> result = new LinkedHashMap<>();

        map.entrySet().stream()
                .sorted(Map.Entry.<K, V>comparingByKey().reversed())
                .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        return result;
    }


    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        Map<K, V> result = new LinkedHashMap<>();

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
        return result;
    }
}
