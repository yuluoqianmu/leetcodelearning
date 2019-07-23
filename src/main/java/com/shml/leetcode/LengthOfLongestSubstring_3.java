package com.shml.leetcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class LengthOfLongestSubstring_3 {

    /**
     * 滑动窗口，使用hashSet的方式
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring_hashSet(String s) {

        Set<Character> set = new HashSet<>();

        int result = 0;
        int i = 0, j = 0;

        while (i < s.length() && j < s.length()) {

            //如果窗口中不包含j指向的字符，则在set窗口中加入该字符
            if (!set.contains(s.charAt(j))) {

                set.add(s.charAt(j));
                j++;
                result = Math.max(result, j - i);

                //如果set窗口中已包含该字符，则将窗口最前面的字符去除
            } else {
                set.remove(s.charAt(i));
                i++;
            }

        }
        return result;

    }

    /**
     * 优化的滑动窗口,使用hashmap代替hashset
     * 使用hahset时，字符串s中的每个字符都没指针i和j访问两次，其真实的时间复杂度为：O(2n)
     * 使用hashmap做优化，当s[j] 在[i,j）范围内有重复的字符时，直接跳过该[i,j重复]范围内的所有元素，变为[j重复+1, j)
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring_hashMap(String s) {

        Map<Character, Integer> map = new HashMap<>();

        int result = 0;

        for (int i=0, j=0; j< s.length(); j++) {

            //如果遇到重复的元素
            if (map.containsKey(s.charAt(j))) {

                //获取重复的元素的位置
                int multiPos = map.get(s.charAt(j));

                //修改窗口的前面的位置
                i = Math.max(multiPos, i);
            }

            //如果不包含重复元素
            //将元素添加的窗口
            map.put(s.charAt(j), j + 1);
            //修改窗口大小
            result = Math.max(result, j - i + 1);
        }
        return result;
    }





    public static void main(String[] args) {
        //System.out.println(lengthOfLongestSubstring_hashSet("abcabcbb"));

        System.out.println(lengthOfLongestSubstring_hashMap("abcabcbb"));
    }
}
