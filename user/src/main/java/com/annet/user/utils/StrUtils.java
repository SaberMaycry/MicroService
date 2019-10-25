package com.annet.user.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * Copyright © 2016 深圳安泰创新科技股份有限公司 版权所有 All Right Reserved
 *
 * @author: Saber
 * 包名：com.annet.datarelay.utils
 * 时间：2019/08/02 22:35
 * 说明：字符串工具
 */
@Slf4j
public class StrUtils {

    private static String ENCODE_GBK = "GBK";
    private static String ENCODE_US7ASCII = "ISO-8859-1";

    public static boolean isNull(String s) {
        return null == s;
    }

    public static boolean notNull(String s) {
        return !isNull(s);
    }

    public static boolean isEmpty(String s) {
        return !isNull(s) && "".equals(s);
    }

    public static boolean notEmpty(String... array) {
        for (String s : array) {
            if (!notEmpty(s))
                return false;
        }
        return true;
    }

    public static boolean notEmpty(String s) {
        return !isNull(s) && s.length() > 0;
    }

    public static boolean isNullOrEmpty(String s) {
        if (isNull(s))
            return true;
        return s.length() == 0;
    }

    /**
     * 去除字符串中的 制表符、换行、回车、32空格、160空格
     *
     * @param src 字符串
     * @return 字符串
     */
    public static String replaceBlank(String src) {
        String dest = "";
        if (src != null) {
            dest = src.replaceAll("\\s", "");
            dest = dest.replaceAll("\t", "");
            dest = dest.replaceAll("\r", "");
            dest = dest.replaceAll("\n", "");
            dest = dest.replaceAll("\\u00A0", "");
        }
        return dest;
    }

    public static String strToUs7ascii(String str) {
        try {
            return new String(str.getBytes(ENCODE_GBK), ENCODE_US7ASCII);
        } catch (UnsupportedEncodingException e) {
            log.error(e.toString());
            return "转码失败！！！";
        }
    }

    public static String us7asciiToStr(String str) {
        try {
            return new String(str.getBytes(ENCODE_US7ASCII), ENCODE_GBK);
        } catch (UnsupportedEncodingException e) {
            log.error(e.toString());
            return "转码失败！！！";
        }
    }


    /**
     * 通过身份证号码获取出生日期、性别、年龄
     *
     * @param certificateNo 身份证号码
     * @return 返回的出生日期格式：1990-01-01   性别格式：F-女，M-男
     */
    public static Map<String, String> getBirAgeSex(String certificateNo) {
        String birthday = "";
        String age = "";
        String sexCode = "";

        int year = Calendar.getInstance().get(Calendar.YEAR);
        char[] number = certificateNo.toCharArray();
        boolean flag = true;
        if (number.length == 15) {
            for (char c : number) {
                if (!flag) {
                    return new HashMap<>();
                }
                flag = Character.isDigit(c);
            }
        } else if (number.length == 18) {
            for (int x = 0; x < number.length - 1; x++) {
                if (!flag) {
                    return new HashMap<>();
                }
                flag = Character.isDigit(number[x]);
            }
        }
        if (flag && certificateNo.length() == 15) {
            birthday = "19" + certificateNo.substring(6, 8) + "-"
                    + certificateNo.substring(8, 10) + "-"
                    + certificateNo.substring(10, 12);
            sexCode = Integer.parseInt(certificateNo.substring(certificateNo.length() - 3)) % 2 == 0 ? "女" : "男";
            age = (year - Integer.parseInt("19" + certificateNo.substring(6, 8))) + "";
        } else if (flag && certificateNo.length() == 18) {
            birthday = certificateNo.substring(6, 10) + "-"
                    + certificateNo.substring(10, 12) + "-"
                    + certificateNo.substring(12, 14);
            sexCode = Integer.parseInt(certificateNo.substring(certificateNo.length() - 4, certificateNo.length() - 1)) % 2 == 0 ? "女" : "男";
            age = (year - Integer.parseInt(certificateNo.substring(6, 10))) + "";
        }
        Map<String, String> map = new HashMap<>(3);
        map.put("birthday", birthday);
        map.put("age", age);
        map.put("sexCode", sexCode);
        return map;
    }


    public static String urlEncoder(String url) {
        String urlData = null;
        try {
            urlData = URLEncoder.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return urlData;
    }

    /**
     * 获得一个guid
     *
     * @return 获得一个guid
     */
    public static String getGUID() {
        return java.util.UUID.randomUUID().toString().replace("-", "");
    }

    public static String getMD5(String info) {
        if (isEmpty(info)) {
            return "";
        }
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(info.getBytes(StandardCharsets.UTF_8));
            byte[] encryption = md5.digest();
            StringBuilder strBuf = new StringBuilder();
            for (byte anEncryption : encryption) {
                if (Integer.toHexString(0xff & anEncryption).length() == 1) {
                    strBuf.append("0").append(Integer.toHexString(0xff & anEncryption));
                } else {
                    strBuf.append(Integer.toHexString(0xff & anEncryption));
                }
            }
            return strBuf.toString().toUpperCase(Locale.US);
        } catch (Exception e) {
            return "";
        }
    }

    public static boolean isAllUpperCase(String str) {
        if (isNullOrEmpty(str)) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c < 'A' || c > 'Z') {
                return false;
            }
        }
        return true;
    }
}
