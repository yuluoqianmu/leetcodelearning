package com.shml.leetcode.page1_20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * ### [20\. 有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)
 Difficulty: **简单**

 给定一个只包括 `'('`，`')'`，`'{'`，`'}'`，`'['`，`']'` 的字符串，判断字符串是否有效。
 有效字符串需满足：
 1.  左括号必须用相同类型的右括号闭合。
 2.  左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。
 **示例 1:**
 输入: "()"
 输出: true
 **示例 2:**
 输入: "()[]{}"
 输出: true
 **示例 3:**
 输入: "(]"
 输出: false
 **示例 4:**
 输入: "([)]"
 输出: false
 **示例 5:**
 输入: "{[]}"
 输出: true
 */
public class IsValidBrackets_20 {

    private static HashMap<Character, Character> mappings;

    public IsValidBrackets_20() {
        this.mappings = new HashMap<>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public static boolean isValid(String s) {

        Stack<Character> stack =  new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (mappings.containsKey(ch)) {
                char topElem = stack.isEmpty() ? '#' : stack.pop();
                if (topElem != mappings.get(ch)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }
}
