package org.leetcode.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 20. 有效的括号
 * @date 2023/6/10 19:21
 */

public class IsValid {
    public boolean isValid(String s) {
        if (s.length() == 0 || s.length() == 1) return false;
        Stack<Character> stack = new Stack<>();
        stack.push('?');
        for (int i = 0; i < s.length(); i++) {
            Character charAt = s.charAt(i);
            switch (charAt) {
                case '(':
                case '[':
                case '{':
                    stack.push(charAt);
                    break;
                case ')':
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }
        stack.pop();
        return stack.isEmpty();
    }
    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        put('?', '?');
    }};

    public boolean isValid2(String s) {
        if (s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        LinkedList<Character> stack = new LinkedList<Character>() {{
            add('?');
        }};
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) stack.addLast(c);
            else if (map.get(stack.removeLast()) != c) return false;
        }
        return stack.size() == 1;
    }
}
