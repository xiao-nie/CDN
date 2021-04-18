package cn.awall.awalladmin.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils {

    /**
     * @param psd
     * @param salt
     * @return MD5加密后的字符串
     * @Des 得到相应的一个MD5加密后的字符串
     */
    public static String encoder(String psd, String salt) {
        try {
            StringBuffer stingBuffer = new StringBuffer();
            // 1.指定加密算法
            MessageDigest digest = MessageDigest.getInstance("MD5");
            // 2.将需要加密的字符串转化成byte类型的数据，然后进行哈希过程
            byte[] bs = digest.digest((psd + salt).getBytes());
            // 3.遍历bs,让其生成32位字符串，固定写法

            // 4.拼接字符串
            for (byte b : bs) {
                int i = b & 0xff;
                String hexString = Integer.toHexString(i);
                if (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                stingBuffer.append(hexString);
            }
            return stingBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
