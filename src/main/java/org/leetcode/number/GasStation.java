package org.leetcode.number;

/**
 * 134. 加油站
 * 题目描述：在一条环路上有 n 个加油站，其中第i个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第i个加油站开往第i+1个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。如果存在解，则保证它是唯一的。
 */

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        // 获取加油站的数量
        int n = gas.length;
        // 一开始，默认汽车储备的汽油数量为0
        int remainGas = 0;
        // 判断所有汽油的总量是否能完成一周
        for (int i = 0; i < n; i++) {
            remainGas += gas[i] - cost[i];
        }
        if (remainGas < 0) {
            return -1;
        }
        // 一开始，默认汽⻋出发位置在索引为 0 的加油站
        int currentGas = 0;
        // index表示最终选择的出发点，默认为0
        int index = 0;
        // 起点的索引
        int i = 0;
        while (i < n) {
            currentGas += gas[i] - cost[i];
            // 如果油量不够，换下一个出发点
            if (currentGas < 0) {
                index = (i + 1);
                currentGas = 0;
            }
            i++;
        }
        return index;
    }

    public static void main(String[] args) {
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};
        int circuit = canCompleteCircuit(gas, cost);
        System.out.println(circuit);
    }
}
