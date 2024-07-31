package com.shml.leetcode.page700_750;

/**
 713. 乘积小于 K 的子数组
 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。

 示例 1：
 输入：nums = [10,5,2,6], k = 100
 输出：8
 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。

 示例 2：
 输入：nums = [1,2,3], k = 0
 输出：0

 提示:
 1 <= nums.length <= 3 * 104
 1 <= nums[i] <= 1000
 0 <= k <= 106
 */
public class NumSubarrayProductLessThanK_713 {

    public static void main(String[] args) {
        int[] test = new int[]{10,5,2,6};
        System.out.println(new NumSubarrayProductLessThanK_713()
                .numSubarrayProductLessThanK(test, 100));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int left = 0, res = 1;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {
            res *= nums[right];
            while (res >= k) {
                res /= nums[left];
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
