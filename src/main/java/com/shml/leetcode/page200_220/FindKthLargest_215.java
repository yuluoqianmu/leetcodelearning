package com.shml.leetcode.page200_220;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * ### [215\. 数组中的第K个最大元素](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/)
 Difficulty: **中等**
 在未排序的数组中找到第 **k** 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 **示例 1:**
 ```
 输入: [3,2,1,5,6,4] 和 k = 2
 输出: 5
 ```
 **示例 2:**
 ```
 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 输出: 4
 ```
 **说明:**

 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class FindKthLargest_215 {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((n1,n2) -> n1-n2);

        for (int n : nums) {
            queue.add(n);
            if (queue.size() > k){
                queue.poll();
            }
        }
        return queue.poll();
    }



    int [] nums;
    public  int findKthLargest_2(int[] nums, int k) {
        this.nums = nums;
        int size = nums.length;
        return quickSelect(0, size-1, size-k);
    }

    public void swap(int a, int b) {
        int tmp = this.nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = tmp;
    }


    public  int quickSelect(int  left, int right, int k_small) {
        if (left == right)
            return this.nums[left];
        Random random = new Random();
        int pivot = left + random.nextInt(right - left);

        pivot = partition(left, right, pivot);
        if (k_small == pivot)
            return this.nums[k_small];
        else if (k_small < pivot)
            return quickSelect(left, pivot-1, k_small);
        else
            return quickSelect(pivot+1, right, k_small);
    }

    public int partition(int left, int right, int pivot_index) {
        int pivot = this.nums[pivot_index];
        swap(pivot_index, right);

        int store_index = left;

        for (int i=left; i<=right; i++) {
           if (this.nums[i] < pivot) {
               swap(store_index, i);
               store_index++;
           }
        }

        swap(store_index, right);
        return store_index;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,5,6,4};
        System.out.println(findKthLargest(arr, 2));
    }
}
