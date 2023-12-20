package org.leetcode.hashMap;

/**
 * @author ChengFl
 * @version 1.0
 * @description: TODO
 * @date 2023/6/28 15:51
 */

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        if (len1 != len2) return false;
        int[] records = new int[26];
        for (int i = 0; i < len1; i++) {
            char str1 = s.charAt(i);
            char str2 = t.charAt(i);
            records[str1 - 'a']++;
            records[str2 - 'a']--;
        }
        for (int i=0;i<26;i++){
            if(records[i]!=0){
                return false;
            }
        }
        return true;
    }
}
