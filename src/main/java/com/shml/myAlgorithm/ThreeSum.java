package com.shml.myAlgorithm;

import java.util.Arrays;

public class ThreeSum {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,-2,-5,-3,-1,1,2,5};
        int target = 8;
        threeSum(arr, 8);
    }


    public static void threeSum(int[] arr, int target) {

        Arrays.sort(arr);

        for (int i=0;  i<arr.length-3; i++) {

            int j = i + 1;
            int k = arr.length - 1;
            while (j < k) {
                if (arr[i] + arr[j] + arr[k] == target) {
                    System.out.println(arr[i]+","+arr[j]+","+arr[k]);
                    j++;
                    k--;
                } else if (arr[i] + arr[j] + arr[k] < target) {
                    j++;
                } else if (arr[i] + arr[j] + arr[k] > target){
                    k--;
                }
            }
        }


    }


}
