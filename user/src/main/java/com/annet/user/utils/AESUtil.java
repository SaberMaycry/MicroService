package com.annet.user.utils;


import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {

    private static final String KEY = "1234567812345678";
    private static final String ALGORITHMSTR = "AES/ECB/PKCS5Padding";

    /**
     * @Desc 加密方法
     * @Param [content, encryptKey]
     * @Return
     */
    public static String encrypt(String content, String key) {
        try {
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            keygen.init(128);
            SecretKey encryptKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
            cipher.init(Cipher.ENCRYPT_MODE, encryptKey);
            byte[] byte_AES = cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));
            String encode = Base64.getEncoder().encodeToString(byte_AES);
            return encode;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String encrypt, String key) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128);
            Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"));
            byte[] decryptBytes = cipher.doFinal(Base64.getDecoder().decode(encrypt));
            return new String(decryptBytes, StandardCharsets.UTF_8);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
