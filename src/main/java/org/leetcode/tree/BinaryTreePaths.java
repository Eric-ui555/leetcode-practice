package org.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChengFl
 * @version 1.0
 * @description: 257. 二叉树的所有路径
 * @date 2024/2/25 17:10
 */

public class BinaryTreePaths {
    /**
     * 前序遍历，方便让父节点指向子节点
     * 回溯，回退当前路径指向另一个路径
     * @param root 根节点
     * @return 路径数组
     */

    public List<String> binaryTreePaths(TreeNode root) {
        // 存放结果集的res
        ArrayList<String> res = new ArrayList<>();
        if(root==null) return res;
        // 存放路径的path
        ArrayList<Integer> path = new ArrayList<>();
        traverse(root,path,res);
        return res;
    }

    public void traverse(TreeNode node, List<Integer> path, List<String> res){
        path.add(node.val); // 前序遍历，中
        // 叶子结点
        if(node.left==null&&node.right==null){
            StringBuilder rPath = new StringBuilder(); // StringBuilder用来拼接字符串，速度更快
            for(int i=0;i<path.size()-1;i++){
                rPath.append(path.get(i).toString()).append("->");
            }
            rPath.append(path.get(path.size()-1)); // 记录最后一个节点
            res.add(String.valueOf(rPath)); // 收集一个路径
            return;
        }
        // 递归和回溯是同时进行，所以要放在同一个花括号里
        if(node.left!=null){ // 左
            traverse(node.left, path, res);
            path.remove(path.size() - 1);// 回溯
        }
        if(node.right!=null){ // 右
            traverse(node.right, path, res);
            path.remove(path.size() - 1);// 回溯
        }
    }
}
