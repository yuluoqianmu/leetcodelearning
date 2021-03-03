package com.shml.leetcode.page21_40;

import java.util.Stack;

/**
 * ### [32\. 最长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses/)
 * Difficulty: ** 示例 1： 输入：s = "(()" 输出：2 解释：最长有效括号子串是 "()"
 * 示例 2： 输入：s = ")()())" 输出：4 解释：最长有效括号子串是 "()()"
 * 示例 3： 输入：s = "" 输出：0   提示： 0 <= s.length <= 3 * 104 s[i] 为 '(' 或 ')' **
 * 给你一个只包含 `'('` 和 `')'` 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * **示例 1：**
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * **示例 2：**
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * **示例 3：**
 * 输入：s = ""
 * 输出：0
 */
public class LongestValidParentheses_32 {

    /**
     * 使用栈数据结构来解决
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        //列举从下标开始，长度是2的字符串
        for (int i=0; i<s.length(); i++) {
            for (int j=i+2; j<s.length(); j+=2) {
                if (isValid(s.substring(i, j))) {
                    maxLen = Math.max(maxLen, j-i);
                }
            }
        }
        return maxLen;
    }

    public boolean isValid(String str) {
        Stack<Character> stack = new Stack();

        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek()=='(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    /**
     * 动态规划方法
     */
    public int longestValidParentheses_2(String s) {
        int result = 0;
        int dp[] = new int[s.length()];
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ')') {
                //如果最后一个字符是），前一个字符是（，则构成一对括号，dp[i] = dp[i-2] + 2
                if (s.charAt(i-1) == '(') {
                    dp[i] = (i>=2 ? dp[i-2] : 0) + 2;
                    //如果最后一个字符是）,前一个字符也是）,而且如果前一个字符之前的字符可以构成一对括号，
                    // 则减去构成的括号的长度后，之前的字符还是（,则最后的字符和该字符构成一对
                } else if (i-dp[i-1] > 0 && s.charAt(i-dp[i-1]-1)=='(') {
                    //那么dp[i]的长度等于dp[i-1]的长度加上2再加上减去dp[i-1]的长度后，前一个的之前的长度
                    dp[i] = dp[i-1] + ((i-dp[i-1])>=2 ? dp[i-dp[i-1]-2] : 0) + 2;
                }
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }

}
