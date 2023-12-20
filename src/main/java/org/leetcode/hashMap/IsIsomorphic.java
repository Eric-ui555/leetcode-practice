package org.leetcode.hashMap;

import java.util.HashMap;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 205. 同构字符串
 * @date 2023/6/28 15:37
 */

public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    private boolean isIsomorphicHelper(String s, String t) {
        int len1 = s.length();
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < len1; i++) {
            Character str1 = s.charAt(i), str2 = t.charAt(i);
            if (map.containsKey(str1)) {
                if (map.get(str1) != str2) {
                    return false;
                }
            } else {
                map.put(str1, str2);
            }
        }
        return true;
    }
}
