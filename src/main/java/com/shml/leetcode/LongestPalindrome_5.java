package com.shml.leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 */
public class LongestPalindrome_5 {

    /**
     * 使用动态规划算法，还可以使用Matcher算法，这里推荐使用动态规划算法
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {

        int len = s.length();
        if (len <= 1) {
            return s;
        }

        /**
         * 如果dp[i,r]=true,那么dp[i+1, r-1]也一定为true
         *
         * 但是[i+1, r-1]至少有两个元素才有判断的必要
         *
         * 等价于 i+1 < r-1, 即：r-i > 2
         */

        int longestPalindrome = 1;
        String longestPalindromeStr = s.substring(0, 1);

        boolean[][] dp = new boolean[len][len];

        for (int i=1; i<len; i++) {
            for (int j=0; j<i; j++) {

                if (s.charAt(i)==s.charAt(j) && (i-j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > longestPalindrome) {
                        longestPalindrome = i - j + 1;
                        longestPalindromeStr = s.substring(j, i + 1);

                    }

                }
            }

        }

        return longestPalindromeStr;


    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
