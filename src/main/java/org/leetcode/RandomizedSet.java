package org.leetcode;

import java.util.*;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 380. O(1) 时间插入、删除和获取随机元素
 * @date 2024/1/25 10:30
 */

public class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> indices;
    Random random;

    public RandomizedSet() {
        list = new ArrayList<>();
        indices = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (indices.containsKey(val)) {
            return false;
        }
        list.add(val);
        indices.put(val, list.size() - 1);
        return true;
    }

    /**
     * 从变长数组中找出最后一项元素，将其转移到待删除元素的位置，保证数组其余索引不变
     * 删除数组最后一项，删除哈希表中的val项
     */
    public boolean remove(int val) {
        if (!indices.containsKey(val)) {
            return false;
        }
        // 找到val在数组中的索引
        int index = indices.get(val);
        // 获取数组最后一项元素
        int last = list.get(list.size() - 1);
        // 将数组最后一项元素移动到index位置处
        list.set(index, last);
        // 更新再哈希表中的索引
        indices.put(last, index);
        // 移除数组最后一项
        list.remove(list.size() - 1);
        // 移除哈希表中的待删除元素
        indices.remove(val);
        return true;
    }

    public int getRandom() {
        int rIndex = random.nextInt(list.size());
        return list.get(rIndex);
    }
}
