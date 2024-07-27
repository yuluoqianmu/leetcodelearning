package com.shml.leetcode.page40_99;

import java.util.ArrayList;
import java.util.List;

public class Subset_78 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        List<Integer> state = new ArrayList<>();
        dfs(state, nums, 0, res);
        return res;
    }
    public static void dfs(List<Integer> state, int[] nums, int index, List<List<Integer>> res) {

        for (int i = index; i < nums.length; i++) {
            state.add(nums[i]);
            res.add(new ArrayList<>(state));
            dfs(state, nums, i+1, res);
            state.remove(state.size() - 1);
        }

    }
}
