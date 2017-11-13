/**
 * Copyright (c) 2017 Qunar.com. All Rights Reserved.
 */
package javaweb.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jintao.wang Date: 17-10-16 Time: 下午8:50
 */
@Slf4j
public class MD5String {

    private static final String[] hexChar = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E",
            "F" };

    /**
     * 利用用户名、密码、登录时间戳构造MD5字符串
     *
     * @param userName
     * @param password
     * @param loginTime
     * @return
     */
    public static String getMD5String(String userName, String password, long loginTime) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(userName));
        Preconditions.checkArgument(!Strings.isNullOrEmpty(password));

        StringBuilder sb = new StringBuilder();
        sb.append(userName);
        sb.append(password);
        sb.append(loginTime);
        byte[] srcData = sb.toString().getBytes();
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            log.error("NoSuchAlgorithmException", e);
        }
        byte[] destData = messageDigest.digest(srcData);
        return byteArrayToString(destData, true);
        /* return sb.substring(0); */
    }

    /**
     *
     * @param arr
     * @param littleEndian
     * @return
     */
    private static String byteArrayToString(byte[] arr, boolean littleEndian) {
        Preconditions.checkNotNull(arr);
        StringBuffer sb = new StringBuffer();
        for (byte b : arr) {
            String result = byteToString(b, littleEndian);
            sb.append(result);
        }
        return sb.substring(0);
    }

    /**
     *
     * @param b
     * @param littleEndian
     * @return
     */
    private static String byteToString(byte b, boolean littleEndian) {
        if (b < 0) {
            b = (byte) (0 - b);
        }
        int low = b & 0x0F;
        int hight = b >>> 4;
        return (littleEndian ? (hexChar[hight] + hexChar[low]) : (hexChar[low] + hexChar[hight]));
    }
}
