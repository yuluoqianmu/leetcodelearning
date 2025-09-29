package com.shml.leetcode.page700_750;

/**
 * 滴滴面试题
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 *  输入：nums = [1,1,0,1,1,1]
 *  输出：3
 *
 * 1,1,0,1,1,1
 * 1,0,1,1,0,1
 */
public class MaxOneSequence {
    public static void main(String[] args) {
        System.out.println(maxSequence(new int[] {1,0,1,1,0,1}));
    }

    public static int maxSequence(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int ans = 0;
        int i = 0;
        while (i + 1 < num.length) {
            int count = 0;
            if (num[i] == 1) {
                count = 1;
            } else {
                count = 0;
            }
            while (i + 1 < num.length && num[i] == num[i + 1] && num[i] == 1) {
                count++;
                i++;
            }
            i++;
            ans = Math.max(ans, count);
        }

        return ans;
    }
}
