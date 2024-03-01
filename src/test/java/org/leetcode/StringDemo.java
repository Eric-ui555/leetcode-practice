package org.leetcode;

/**
 * @author ChengFl
 * @version 1.0
 * @description: TODO
 * @date 2024/2/27 15:41
 */

public class StringDemo {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        String a = "我爱吃接西红柿";
        a += "我爱吃接西红柿sada";
        Class<? extends String> aClass = a.getClass();
        Integer i = Integer.class.newInstance();
        System.out.println(a);
    }
}
