package com.shml.leetcode.page100_120;

public class IsPalindrome_125 {

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str));

    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^A-Za-z0-9]", "");

        char[] strArr = s.toCharArray();

        int left = 0, right = strArr.length -1;
        while (left <= right) {
            if (strArr[left] != strArr[right]) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
