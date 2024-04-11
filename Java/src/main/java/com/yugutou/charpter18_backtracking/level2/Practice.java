package com.yugutou.charpter18_backtracking.level2;

import java.util.*;

public class Practice {

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};

//        System.out.println(combinationSum(candidates, 7));
        System.out.println(partition("aab"));
    }

    /**
     * 组合综合问题
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new LinkedList<>();

        LinkedList<Integer> path = new LinkedList<>();
        // 排序 方便剪枝
        Arrays.sort(candidates);

        dfs(candidates, target, 0, res, path);
        return res;
    }

    public static void dfs(int[] candidates, int target, int index, List<List<Integer>> res, LinkedList<Integer> path) {
        // 退出条件
        if (target < 0) return;

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) break;
            // 开始遍历递归
            path.addLast(candidates[i]);
            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));
            dfs(candidates, (target - candidates[i]), i, res, path);
            // 回朔
            path.removeLast();
            System.out.println("递归之后 => " + path + "，剩余 = " + (target));
        }

    }

    /**
     * 分割回文串
     */
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        Deque<String> deque = new LinkedList<>();
        // 主要算法
        backTracing(s, 0, res, deque);
        return res;
    }

    public static void backTracing(String s, int startIndex, List<List<String>> res, Deque<String> deque) {
        // 退出条件 起始位置已经遍历到了最后
        if (startIndex >= s.length()) {
            res.add(new ArrayList<>(deque));
            return;
        }

        // 遍历
        for (int i = startIndex; i < s.length(); i++) {
            // 判断是否是回文串并 加入队列
            if (isPalindrome(s, startIndex, i)) {
                String str = s.substring(startIndex, i + 1);
                deque.addLast(str);
            } else {
                continue;
            }

            backTracing(s, i + 1, res, deque);
            // 回朔
            deque.removeLast();
        }
    }

    private static boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

}
