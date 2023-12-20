package org.leetcode.mock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 682. 棒球比赛
 * @date 2023/12/18 9:19
 */

public class CalPoints {
    public int calPoints(String[] ops) {
        int sum = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (String operation : ops) {
            char ch = operation.charAt(0);
            int n = stack.size();
            if (ch == '+') {
                sum += stack.get(n - 1) + stack.get(n - 2);
                stack.add(stack.get(n - 1) + stack.get(n - 2));
            } else if (ch == 'D') {
                sum += 2 * stack.get(n - 1);
                stack.add(2 * stack.get(n - 1));
            } else if (ch == 'C') {
                sum -= stack.get(n-1);
                stack.remove(n-1);
            } else {
                sum += Integer.parseInt(operation);
                stack.add(Integer.parseInt(operation));
            }
        }
        return sum;
    }

    /**
     * 官方解法
     */
    public int calPoints2(String[] ops) {
        int ret = 0;
        List<Integer> points = new ArrayList<Integer>();
        for (String op : ops) {
            int n = points.size();
            switch (op.charAt(0)) {
                case '+':
                    ret += points.get(n - 1) + points.get(n - 2);
                    points.add(points.get(n - 1) + points.get(n - 2));
                    break;
                case 'D':
                    ret += 2 * points.get(n - 1);
                    points.add(2 * points.get(n - 1));
                    break;
                case 'C':
                    ret -= points.get(n - 1);
                    points.remove(n - 1);
                    break;
                default:
                    ret += Integer.parseInt(op);
                    points.add(Integer.parseInt(op));
                    break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String[] arr = {"5","2","C","D","+"};
        CalPoints calPoints = new CalPoints();
        int i = calPoints.calPoints(arr);
        System.out.println(i);
    }
}
