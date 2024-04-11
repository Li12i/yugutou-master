package com.yugutou.charpter18_backtracking.level1;

import com.yugutou.charpter1_linklist.level1.ListNode;
import com.yugutou.tools.TreeNode;

import java.util.*;

public class Practice {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        System.out.println(binaryTreePaths(root));
        System.out.println(pathSum(root, 3));
    }


    /**
     * 77. 组合
     * <a href="https://leetcode.cn/problems/combinations/description/">...</a>
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if (n < k || k <= 0) return res;

        // 存放路径
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    public static void dfs(int n, int k, int startIndex, Deque<Integer> path, List<List<Integer>> res) {
        // 结束条件为：path路径的长度 = 我们所需长度的时候
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 每层逐个递归，递归前加入该层元素，因为要的不是叶子节点，而是树干部分
        for (int i = startIndex; i <= n; i++) {
            path.addLast(i);
            // 向下递归
            dfs(n, k, i + 1, path, res);
            // 递归完之后需要去掉该层的节点
            path.removeLast();
        }
    }

    /**
     * 所有路径
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return null;
        List<Integer> path = new ArrayList<>();
        List<String> res = new ArrayList<>();
        dfs(root, path, res);
        return res;
    }

    public static void dfs(TreeNode root, List<Integer> path, List<String> res) {
        if (root == null) return;

        // 退出条件：该节点是叶子节点
        path.add(root.val);
        if (root.left == null && root.right == null) {
            res.add(getPathString(path));
        }

        // 递归条件
        if (root.left != null) {
            dfs(root.left, path, res);
        }
        if (root.right != null) {
            dfs(root.right, path, res);
        }
        path.remove(path.size() - 1);
    }

    public static String getPathString(List<Integer> temp) {
        StringBuilder sb = new StringBuilder();
        sb.append(temp.get(0));
        for (int i = 1; i < temp.size(); ++i) {
            sb.append("->").append(temp.get(i));
        }
        return sb.toString();
    }

    /**
     * 113. 路径总和 II
     * <a href="https://leetcode.cn/problems/path-sum-ii/description/">...</a>
     */
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(root, targetSum, res, path);
        return res;
    }

    public static void dfs(TreeNode root, int targetSum, List<List<Integer>> res, LinkedList<Integer> path) {
        // 退出条件
        if (root == null) return;

        path.add(root.val);
        targetSum -= root.val;
        // 必须是叶子节点 并且 减到叶子节点的时候为0
        if (targetSum == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));
        }

        // 左节点
        dfs(root.left, targetSum, res, path);
        // 右节点
        dfs(root.right, targetSum, res, path);

        // 回朔
        path.removeLast();
    }

}
