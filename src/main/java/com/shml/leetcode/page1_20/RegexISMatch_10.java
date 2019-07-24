package com.shml.leetcode.page1_20;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 */
public class RegexISMatch_10 {

    /**
     * 递归法
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        //匹配第一个字符
        boolean first_match = (!s.isEmpty() &&
                (p.charAt(0) == s.charAt(0) || p.charAt(0)=='.'));

        //递归
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p));
        } else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }

    }

    /**
     * 动态规划法
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch_dp(String s, String p) {

        boolean dp[][] = new boolean[s.length()+1][p.length()+1];

        dp[s.length()][p.length()] = true;

        for (int i=s.length(); i>=0; i--) {
            for (int j=p.length()-1; j>=0; j--) {
                boolean firstMatch = (i < s.length() &&
                        (p.charAt(j) == s.charAt(i) || p.charAt(j)=='.'));

                if (j+1 < p.length() && p.charAt(j+1)=='*') {

                    dp[i][j] = dp[i][j+2] || firstMatch && dp[i+1][j];

                } else {

                    dp[i][j] = firstMatch && dp[i+1][j+1];

                }
            }
        }
        return dp[0][0];


    }

    public static void main(String[] args) {
        System.out.println(isMatch_dp("aaa", "a*"));
    }


}
