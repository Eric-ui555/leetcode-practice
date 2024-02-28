package org.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * @author ChengFl
 * @version 1.0
 * @description: TODO
 * @date 2024/2/27 15:41
 */

public class StringDemo {
    public static final String b = "我爱吃西红柿";
    public static final String a = "我爱吃西红柿";
    public static void main(String[] args) {
        final String a = "ab";
        final String b = "a" + "b";
        System.out.println(a == b);

        HashMap<String, String> map = new LinkedHashMap<>(4);
        TreeMap<String, String> stringStringTreeMap = new TreeMap<String, String>();
    }
}
