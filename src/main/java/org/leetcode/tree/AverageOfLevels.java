package org.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChengFl
 * @version 1.0
 * @description: TODO
 * @date 2024/2/25 16:07
 */

public class AverageOfLevels {
    private final List<List<Integer>> resList = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        checkFunc(root, 0);
        ArrayList<Double> res = new ArrayList<Double>();
        for(List<Integer> temp : resList){
            res.add(doubleArrAverage(temp));
        }
        return res;
    }

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
}
