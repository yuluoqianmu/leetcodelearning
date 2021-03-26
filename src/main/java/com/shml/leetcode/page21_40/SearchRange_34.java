package com.shml.leetcode.page21_40;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange_34 {

    /**
     *给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     * 进阶：
     * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
     *
     * 示例 1：
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     *
     * 示例 2：
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     *
     * 示例 3：
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     */
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }

        int firstPost = findFirstPost(nums, target);
        if (firstPost == -1) {
            return new int[]{-1, -1};
        }

        int lastPos = findLastPos(nums, target);

        return new int[]{firstPost, lastPos};
    }

    public int findFirstPost(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid  = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    public int findLastPos(int nums[], int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }  else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                left = mid;
            }
        }

        return left;
    }


    public int[] searchRange_2(int[] nums, int target) {
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false) - 1;

        if (left<=right && right<nums.length && nums[left]==target && nums[right]==target) {
            return new int[]{left, right};
        }
        return new int[]{-1,-1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1;
        int ans = nums.length;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (nums[mid] > target || (lower && nums[mid]>=target )) {
                right = mid - 1;
                ans = mid;
            } else  {
                left = mid + 1;
            }
        }
        return ans;
    }
}
