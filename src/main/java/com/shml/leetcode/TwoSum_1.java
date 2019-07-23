package com.shml.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);

        for (int i=0; i<result.length; i++) {
            System.out.println(result[i]);
        }
    }




    public static int[] twoSum(int[] nums, int target) {
        //返回结果数组
        int[] ret = new int[2];

        Map<Integer, Integer> map = new HashMap<>();
        //采用一边遍历一边查找的方式
        for (int i=0; i<nums.length; i++) {
            int temp = target - nums[i];

            if (map.containsKey(temp) ) {
                ret[0] = i;
                ret[1] = map.get(temp);
                return ret;
            } else {
                map.put(nums[i], i);
            }

        }
        return null;
    }
}
