package org.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 515. 在每个树行中找最大值
 * @date 2024/2/25 16:26
 */

public class LargestValues {
    public List<Integer> largestValues(TreeNode root) {
        checkFunc(root, 0);
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(List<Integer> temp : resList){
            res.add(getArrMaxValue(temp));
        }
        return res;
    }
    private final List<List<Integer>> resList = new ArrayList<>();

    /**
     * 深度优先搜索实现层次遍历
     * @param root 结点
     * @param deep 树的深度
     */
    private void checkFunc(TreeNode root, int deep) {
        if(root == null) return;
        deep++;
        // 判断结果数组大小与树深度大小是否一致
        if(resList.size()<deep){
            // 不一致，则向结果数组中插入空数组
            List<Integer> item = new ArrayList<Integer>();
            resList.add(item);
        }
        // 向结果数组添加值
        resList.get(deep-1).add(root.val);

        checkFunc(root.left, deep);
        checkFunc(root.right, deep);
    }

    /**
     * 计算一个数组的平均值
     * @param arr 数组
     * @return 平均值
     */
    public double doubleArrAverage(List<Integer> arr) {
        double sum = 0;
        for (Integer v : arr) {
            sum += v;
        }
        return sum / arr.size();
    }

    /**
     * 计算一个数组的最大值
     * @param arr 数组
     * @return 最大值
     */
    public Integer getArrMaxValue(List<Integer> arr){
        int max = Integer.MIN_VALUE;
        for(Integer v : arr){
            max = Math.max(v, max);
        }
        return max;
    }
}
