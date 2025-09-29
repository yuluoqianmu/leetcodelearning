package com.shml.leetcode.page700_750;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 最长山脉的长度
     * @param  int整型一维数组 每个元素表示一座山的高度
     * @return int整型
     */

    public static void main(String[] args) {
        System.out.println(maxLength(new int[]{2,2,2,2,1}));
    }


    public static int maxLength (int[] nums) {
        // write code here
        if (nums == null) {
            return 0;
        }
        int len = nums.length;
        if (len < 3) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();

        int maxLen = 0;
        int left = 0, right = 0;
        while (right < len) {

            while (right - left + 1 < 3) {
                list.add(nums[right]);
                right++;
            }
            while (right < len && right - left + 1 >= 3 ) {
                list.add(nums[right]);
                if (isExistRindge(list)) {
                    right++;
                    maxLen = Math.max(maxLen, right - left);
                } else {
                    list.remove(left);
                    left++;
                }
            }
        }

        return maxLen;
    }
    public static boolean isExistRindge(List<Integer> list) {
        boolean ans = false;
        if (list.get(0) >= list.get(1)) {
            ans = false;
            return ans;
        }
        if (list.get(list.size() - 1) >= list.get(list.size() - 2)) {
            ans = false;
            return ans;
        }
        for (int i = 0; i < list.size(); i++) {
            if (i + 1 < list.size() && list.get(i) < list .get(i+1)) {
                return true;
            }
        }
        return ans;
    }
}
