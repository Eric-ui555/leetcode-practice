package org.leetcode.string;

import java.util.ArrayList;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 6.Z字形变换
 * @date 2024/2/23 9:12
 */

public class NConvert {
    /**
     * 行索引的规律
     * @param s 输入字符串
     * @param numRows 行数
     * @return 变换后的字符串
     */
    public String convert(String s, int numRows) {
        if (numRows  < 2) return s;
        ArrayList<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        // 遍历字符串
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }
}
