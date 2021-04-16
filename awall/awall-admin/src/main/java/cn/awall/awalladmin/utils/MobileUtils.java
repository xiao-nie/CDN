package cn.awall.awalladmin.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileUtils {

    //手机号规则验证类
    public static boolean isMobileNO(String pnumber) {
        System.out.println(pnumber);
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4])|(18[0-9])|(17[0-9])|(147))\\d{8}$");
        Matcher m = p.matcher(pnumber);
        return m.matches();//有效返回true,否则返回false
    }

}