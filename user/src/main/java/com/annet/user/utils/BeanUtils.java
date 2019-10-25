package com.annet.user.utils;

import com.esotericsoftware.reflectasm.MethodAccess;

import org.springframework.util.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import lombok.extern.slf4j.Slf4j;

/**
 * Copyright © 2016 深圳安泰创新科技股份有限公司 版权所有 All Right Reserved
 *
 * @author: Saber
 * 包名：com.annet.datarelay.utils
 * 时间：2019/08/12 12:16
 * 说明：
 */
@Slf4j
public class BeanUtils {
    public static void copyProperties(Object desc, Object original) {
        org.springframework.beans.BeanUtils.copyProperties(original, desc);
    }

    /**
     * 根据key值排序
     *
     * @param keyExtractor map
     * @param <T>          map
     * @return map
     */
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    private static Map<Class, MethodAccess> methodMap = new HashMap<>();

    private static Map<String, Integer> methodIndexMap = new HashMap<>();

    private static Map<Class, List<String>> fieldMap = new HashMap<>();

    /**
     * 复制同属性对象，注意，boolean 对象，命名不能用is开头，直接用属性名称
     * 此方法暂不要用
     *
     * @param desc     目标对象
     * @param original 原始对象
     */
    public static void copyPropertiesOld(Object desc, Object original) {
        MethodAccess descMethodAccess = methodMap.get(desc.getClass());
        if (descMethodAccess == null) {
            descMethodAccess = cache(desc);
        }
        MethodAccess originalMethodAccess = methodMap.get(original.getClass());
        if (originalMethodAccess == null) {
            originalMethodAccess = cache(original);
        }

        List<String> fieldList = fieldMap.get(original.getClass());
        for (String field : fieldList) {
            String getKey = original.getClass().getName() + "." + "get" + field;
            String setKey = desc.getClass().getName() + "." + "set" + field;
            Integer setIndex = methodIndexMap.get(setKey);
            if (setIndex != null) {
                Integer getIndex = methodIndexMap.get(getKey);
                if (getIndex == null) {
                    getIndex = methodIndexMap.get(original.getClass().getName() + "." + "is" + field);
                }

                // 参数一需要反射的对象
                // 参数二class.getDeclaredMethods 对应方法的index
                // 参数对三象集合
                descMethodAccess.invoke(desc, setIndex, originalMethodAccess.invoke(original, getIndex));
            }
        }
    }

    // 单例模式
    private static MethodAccess cache(Object object) {
        synchronized (object.getClass()) {
            MethodAccess methodAccess = MethodAccess.get(object.getClass());
            Field[] fields = object.getClass().getDeclaredFields();
            List<String> fieldList = new ArrayList<>(fields.length);
            for (Field field : fields) {
                if (Modifier.isPrivate(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) { // 是否是私有的，是否是静态的
                    // 非公共私有变量
                    String fieldName = StringUtils.capitalize(field.getName()); // 获取属性名称

                    int getIndex;
                    int setIndex;
                    String name = field.getType().getName();
                    // 如果是Boolean字段，需要额外处理
                    if ("boolean".equals(name)) {
                        getIndex = methodAccess.getIndex("is" + fieldName); // 获取is方法的下标
                        methodIndexMap.put(object.getClass().getName() + "." + "is" + fieldName, getIndex); // 将类名get方法名，方法下标注册到map中
                    } else {
                        getIndex = methodAccess.getIndex("get" + fieldName); // 获取get方法的下标
                        methodIndexMap.put(object.getClass().getName() + "." + "get" + fieldName, getIndex); // 将类名get方法名，方法下标注册到map中
                    }

                    setIndex = methodAccess.getIndex("set" + fieldName); // 获取set方法的下标
                    methodIndexMap.put(object.getClass().getName() + "." + "set" + fieldName, setIndex); // 将类名set方法名，方法下标注册到map中
                    fieldList.add(fieldName); // 将属性名称放入集合里
                }
            }
            fieldMap.put(object.getClass(), fieldList); // 将类名，属性名称注册到map中
            methodMap.put(object.getClass(), methodAccess);
            return methodAccess;
        }
    }

    public static <T> List<T> deepCopy(List<T> src) {
        try {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(src);

            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);
            @SuppressWarnings("unchecked")
            List<T> dest = (List<T>) in.readObject();
            return dest;
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            return null;
        }
    }
}
