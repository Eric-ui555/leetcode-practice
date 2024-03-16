package org.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author ChengFl
 * @version 1.0
 * @description: TODO
 * @date 2024/2/28 17:12
 */

public class Demo1 {
    public static void main(String[] args) {
        // int i = 0;
        // i = ++i;
        // System.out.println(i);

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(15);

        for (Integer integer : hashSet) {
            System.out.println(integer);
        }
        String a1 = "abc";
        String a2 = "abc";
        HashMap<String, Object> map = new HashMap<>();
        map.put("abc", a1);
        map.put("abc", a1);
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("abc", a2);
        System.out.println(map.hashCode());
        System.out.println(map2.hashCode());

        System.out.println(map.get("abc") == map2.get("abc"));


    }
}
