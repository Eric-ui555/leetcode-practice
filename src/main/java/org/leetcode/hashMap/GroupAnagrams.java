package org.leetcode.hashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 49. 字母异位词分组
 * @date 2023/7/7 9:03
 */

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> stringListHashMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            List list = stringListHashMap.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            stringListHashMap.put(key,list);
        }
        return new ArrayList<>(stringListHashMap.values());
    }
}
