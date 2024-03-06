package org.leetcode.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 22. 括号生成
 * @date 2024/3/5 9:09
 */

public class GenerateParenthesis {
    /**
     * 暴力解法：我们可以生成所有 ‘(’ 和 ‘)’字符构成的序列，然后我们检查每一个是否有效即可。
     */
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<String>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c : current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}
