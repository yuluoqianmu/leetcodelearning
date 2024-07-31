package com.shml.leetcode.page200_220;

/**
 209. 长度最小的子数组
 给定一个含有 n 个正整数的数组和一个正整数 target 。
 找出该数组中满足其总和大于等于 target 的长度最小的子数组[numsl, numsl+1, ..., numsr-1, numsr]，
 并返回其长度。如果不存在符合条件的子数组，返回 0 。

 示例 1：
 输入：target = 7, nums = [2,3,1,2,4,3]
 输出：2
 解释：子数组 [4,3] 是该条件下的长度最小的子数组。

 示例 2：
 输入：target = 4, nums = [1,4,4]
 输出：1

 示例 3：
 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 输出：0

 提示：
 1 <= target <= 109
 1 <= nums.length <= 105
 1 <= nums[i] <= 105
 */
public class MinSubArrayLen_209 {
    public static void main(String[] args) {
        int[] test = new int[]{2,3,1,2,4,3};
        System.out.println(new MinSubArrayLen_209().minSubArrayLen(7, test));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int len = nums.length;
        int i = 0, sum = 0;

        for (int j = 0; j < len; j++) {
            sum += nums[j];
            while (sum >= target) {
                ans = Math.min(ans, j - i + 1);
                sum -= nums[i];
                i++;
            }

        }
        return ans <= len ? ans : 0;
    }
}
