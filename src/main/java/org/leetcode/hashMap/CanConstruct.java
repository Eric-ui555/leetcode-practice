package org.leetcode.hashMap;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 383. 赎金信
 * @date 2024/3/16 9:52
 */

public class CanConstruct {
    int[] nums = new int[26];

    public boolean canConstruct(String ransomNote, String magazine) {
        for (int i = 0; i < magazine.length(); i++) {
            nums[magazine.charAt(i) - 'a']++;
        }
        for (int j = 0; j < ransomNote.length(); j++) {
            if (nums[ransomNote.charAt(j) - 'a'] > 0) {
                nums[ransomNote.charAt(j) - 'a']--;
            } else {
                return false;
            }
        }
        return true;
    }
}
