package com.shml.leetcode.page1_20;

import java.util.Arrays;

/**
 * ### [16\. 最接近的三数之和](https://leetcode-cn.com/problems/3sum-closest/)

 Difficulty: **中等**

 给定一个包括 _n_ 个整数的数组 `nums`和 一个目标值 `target`。找出 `nums`中的三个整数，使得它们的和与 `target` 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

 ```
 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

 与 target 最接近的三个数的和为 2\. (-1 + 2 + 1 = 2).
 ```

 */
public class ThreeSumClosest_16 {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[2];

        for (int i=0; i<nums.length; i++) {
            int start = i + 1, end = nums.length - 1;

            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - result))
                    result = sum;
                if (sum < target)
                    start++;
                else if (sum > target)
                    end--;
                else
                    return result;
            }
        }
        return result;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        System.out.println(threeSumClosest(nums, 1));
    }

}