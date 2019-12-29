package com.shml.leetcode.page1_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ### [18\. 四数之和](https://leetcode-cn.com/problems/4sum/)

 给定一个包含 _n_ 个整数的数组 `nums` 和一个目标值 `target`，判断 `nums` 中是否存在四个元素 _a，__b，c_ 和 _d_ ，使得 _a_ + _b_ + _c_ + _d_ 的值与 `target` 相等？找出所有满足条件且不重复的四元组。

 **注意：**

 答案中不可以包含重复的四元组。

 **示例：**

 ```
 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

 满足要求的四元组集合为：
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]
 ```
 */
public class FourSum_18 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return result;
        }
        //先对数组进行排序，时间复杂度为O(nlgn)
        Arrays.sort(nums);

        /**
         * 定义h,i,j,k四个指针
         */
        for (int h=0; h<nums.length-3; h++) {
            if (h>0 && nums[h]==nums[h-1]) {
                continue;
            }
            int min1 = nums[h] + nums[h+1] + nums[h+2] + nums[h+3];
            if (min1 > target){
                break;
            }
            int max1 = nums[h] + nums[nums.length-1] + nums[nums.length-2] + nums[nums.length-3];
            if (max1 < target){
                continue;
            }

            for (int i=h+1; i<nums.length-2; i++) {
                if (i>h+1 && nums[i]==nums[i-1]) {
                    continue;
                }
                int j = i + 1;
                int k = nums.length - 1;

                int min = nums[h] + nums[i] + nums[j] + nums[j+1];
                if (min > target){
                    continue;
                }
                int max = nums[h] + nums[i] + nums[k-1] + nums[k];
                if (max < target) {
                    continue;
                }

                while (j < k) {
                    int cur = nums[h] + nums[i] + nums[j] + nums[k];
                    if (cur == target) {
                        result.add(Arrays.asList(nums[h], nums[i], nums[j], nums[k]));
                        j++;
                        while (j<k && nums[j]==nums[j-1]){
                            j++;
                        }
                        k--;
                        while (j<k && i<k && nums[k] == nums[k+1]){
                            k--;
                        }
                    } else if (cur <target) {
                        j++;
                    }else {
                        k--;
                    }
                }

            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        List<List<Integer>> ret =  fourSum(nums, 0);

        for (int i=0; i<ret.size(); i++) {
            List<Integer> list= ret.get(i);

            for (int num : list) {
                System.out.print(num+" ");
            }
            System.out.println("");
        }

    }
}
