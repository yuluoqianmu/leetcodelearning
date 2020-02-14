package com.shml.leetcode.page21_40;

import java.util.ArrayList;
import java.util.List;

/**
 * ### [22\. 括号生成](https://leetcode-cn.com/problems/generate-parentheses/)
 Difficulty: **中等**
 给出 _n_ 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且**有效的**括号组合。
 例如，给出 _n_ =3，生成结果为：
 ```
 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 ```
 */
public class GenerateParenthesis_22 {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack("", result, n, n);

        return result;
    }

    /**
     * 回溯法，动态规划
     * @param subList
     * @param result
     * @param left
     * @param right
     */
    public static void backtrack(String subList, List<String> result, int left, int right) {
            if (left == 0 && right == 0) {
                result.add(subList);
                return ;
            }
            if (left > 0) {
                backtrack(subList+"(", result, left-1, right);
            }
            if (left < right) {
                backtrack(subList+")", result, left, right-1);
            }
    }

    public static void backtrack_2(String cur, List<String> result, int left, int right, int max) {
        if (cur.length() == max<<1) {
            result.add(cur);
            return;
        }

        if (left < max) {
            backtrack_2(cur+"(", result, left+1, right, max);
        }

        if (right < left) {
            backtrack_2(cur+")", result, left, right+1, max);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

}
