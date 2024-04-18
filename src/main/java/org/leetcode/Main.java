package org.leetcode;

import java.util.Scanner;

/**
 * @author ChengFl
 * @version 1.0
 * @description: TODO
 * @date 2024/4/10 23:38
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] s = in.nextLine().split(" ");
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (s[j].compareTo(s[min]) < 0) {
                    min = j;
                }
            }
            if (i != min) {
                String temp = s[i];
                s[i] = s[min];
                s[min] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(s[i] + " ");
        }
    }
}
