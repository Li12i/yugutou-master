package com.yugutou.charpter18_backtracking.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Practice {

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};

        System.out.println(combinationSum(candidates, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new LinkedList<>();

        LinkedList<Integer> path = new LinkedList<>();
        // 排序 方便剪枝
        Arrays.sort(candidates);

        dfs1(candidates, target, 0, res, path);
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

    public static void dfs1(int[] candidates, int target, int index, List<List<Integer>> res, LinkedList<Integer> path) {
        // 退出条件
        if (target < 0) return;

        path.addLast(candidates[index]);
        target -= candidates[index];

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // 开始遍历递归
            System.out.println("递归之前 => " + path + "，剩余 = " + (target));
            dfs1(candidates, (target), i, res, path);
            System.out.println("递归之后 => " + path + "，剩余 = " + (target));
        }

        // 回朔
        path.removeLast();
    }
}
