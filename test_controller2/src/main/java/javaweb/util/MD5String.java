/**
 * Copyright (c) 2017 Qunar.com. All Rights Reserved.
 */
package javaweb.util;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/**
 * @author jintao.wang  Date: 17-10-16 Time: 下午8:50
 */
public class MD5String {
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
        /*
         * byte[] srcData = sb.toString().getBytes(); MessageDigest messageDigest = null; try { messageDigest =
         * MessageDigest.getInstance("MD5"); } catch (NoSuchAlgorithmException e) {
         * log.error("NoSuchAlgorithmException", e); } byte[] destData = messageDigest.digest(srcData); return new
         * String(destData);
         */
        return sb.substring(0);
    }
}
    