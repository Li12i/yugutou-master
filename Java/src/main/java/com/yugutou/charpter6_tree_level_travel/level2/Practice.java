package com.yugutou.charpter6_tree_level_travel.level2;

import com.yugutou.tools.BinaryTree;

import java.util.*;

/**
 * @author by GOATLi
 * date: 2023-11-16.
 */
public class Practice {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();

        if (root != null) {
            queue.addLast(root);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            // 每层的最小值
            int maxValue = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                // 1.取出值
                TreeNode poll = queue.poll();
                // 2.比较大小
                maxValue = Math.max(poll.val, maxValue);
                // 3.将第三层放入
                if (poll.left != null) queue.addLast(poll.left);
                if (poll.right != null) queue.addLast(poll.right);
            }

            res.add(maxValue);
        }

        return  res;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            double size = queue.size();
            double sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }

            res.add(sum / size);
        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

