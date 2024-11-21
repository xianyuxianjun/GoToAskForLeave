package com.chenxianyu.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encryptor {

    /**
     * 对字符串进行 MD5 加密
     *
     * @param input 需要加密的字符串
     * @return 加密后的字符串
     */
    public static String encryptToMD5(String input) {
        try {
            // 获取 MessageDigest 实例
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 添加数据
            byte[] inputByteArray = input.getBytes();
            md.update(inputByteArray);

            // 计算哈希值
            byte[] resultByteArray = md.digest();

            // 转换成可读格式
            StringBuilder hexValue = new StringBuilder();
            for (byte b : resultByteArray) {
                int val = ((int) b) & 0xff;
                if (val < 16) {
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }

            // 返回加密后的字符串
            return hexValue.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}