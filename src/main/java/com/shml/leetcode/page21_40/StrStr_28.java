package com.shml.leetcode.page21_40;

public class StrStr_28 {

    /**
     * ### [28\. 实现 strStr()](https://leetcode-cn.com/problems/implement-strstr/)
     *
     * Difficulty: **简单**
     *
     * 实现  函数。
     *
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  **-1**。
     *
     * **示例 1:**
     *
     * ```
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * ```
     *
     * **示例 2:**
     *
     * ```
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * ```
     *
     * **说明:**
     *
     * 当 `needle` 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     *
     * 对于本题而言，当 `needle` 是空字符串时我们应当返回 0 。这与C语言的  以及 Java的  定义相符。
     *
     * ```
     */


    /**
     * Sunday算法
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {

        int haylen = haystack.length();
        int nlen = needle.length();

        //haystack串的指针索引
        int i=0;
        //needle串的指针索引
        int j=0;


        //当haystack剩余字符串少于needle字符串时跳过比较
        while (i <= (haylen - nlen)) {
            //将needle串与haystack串中参与比较的子串，进行逐个字符对比
            while (j<nlen && haystack.charAt(i+j) == needle.charAt(j)) {
                j++;
            }

            //如果j等于needle串的长度，则表示匹配成功
            if (j == nlen) {
                return i;
            }

            //不匹配时需要跳过的字符数，移动主串指针i
            if (i < haylen - nlen) {
                //对照字符在needle串存在，则需要跳过的字符数为
                // 从对照字符在needle串中最后出现的位置开始剩余的字符数
                //不存在则跳过字符数为needle串长度加1，也就是nlen-(-1)的情况
                i += (nlen - lastIndex(needle, haystack.charAt(i+nlen)));

            } else {
                return -1;
            }

            j = 0;

        }
        return -1;

    }

    public static int lastIndex (String str, char ch) {
        //从后往前检索
        for (int j=str.length()-1; j>=0; j--) {
            if (str.charAt(j) == ch) {
                return j;
            }
        }
        return -1;

    }


    public static void main(String[] args) {
        System.out.println(strStr("here every where", "where"));
    }
}
