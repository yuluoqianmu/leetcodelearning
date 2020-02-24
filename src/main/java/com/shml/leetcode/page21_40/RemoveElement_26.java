package com.shml.leetcode.page21_40;

public class RemoveElement_26 {

    public static int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;

        for (int j=0; j<nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,2,3,0,4,2};

        System.out.println(removeElement(arr, 2));

    }
}
