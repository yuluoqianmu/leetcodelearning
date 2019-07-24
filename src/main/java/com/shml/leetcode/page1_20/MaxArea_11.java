package com.shml.leetcode.page1_20;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 *
 * 理解题意：
 * 垂直的两条线段将会与坐标轴构成一个矩形区域，较短线段的长度将会作为矩形区域的宽度，
 * 两线间距将会作为矩形区域的长度，而我们必须最大化该矩形区域的面积。
 *
 */
public class MaxArea_11 {

    /**
     *  暴力解法
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {

        int maxArea = 0;

        for (int i=0; i<height.length; i++) {
            for (int j=i+1; j<height.length; j++) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j-i));
            }
        }

        return maxArea;
    }

    /**
     * 双指针法
     * @param height
     * @return
     */
    public static int maxArea_double_point(int[] height) {
        //最大面积
        int maxArea = 0;

        //左指针和右指针
        int l = 0, r = height.length - 1;

        while (l < r) {

            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));

            /**
             * 移动指针
             */
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }




    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea_double_point(arr));
    }
}
