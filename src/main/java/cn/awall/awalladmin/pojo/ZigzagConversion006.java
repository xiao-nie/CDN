package cn.javae.leetcode;

/**
 * 6. Z 字形变换
 *
 * @author nie
 * @date 2022/11/21 20:50
 **/
public class ZigzagConversion006 {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        String convert = convert(s, 4);
        System.out.println(convert);
    }

    public static String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        int flag = -1;
        String[] str = new String[numRows];
        for (int i = 0; i < str.length; i++) {
            str[i] = "";
        }
        char[] chars = s.toCharArray();
        int x = 0;
        for (int i = 0; i < chars.length; i++) {
            str[x] += chars[i];
            if (x == 0 || x == (numRows - 1)) {
                flag = -flag;
            }
            x += flag;
        }
        s = "";
        for (String s1 : str) {
            s += s1;
        }
        return s;
    }

}
