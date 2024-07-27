package com.shml.leetcode.page40_99;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
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
