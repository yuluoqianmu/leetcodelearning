package com.shml.leetcode.page21_40;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 */
public class FindSubstring_30 {

    /**
     * 思路一：利用hash表，判断截取的字符串是否和hash表中存在的字符串数目一样
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        //单词总数
        int wordNum = words.length;

        if (wordNum == 0) {
            return res;
        }
        //单词长度
        int wordLen = words[0].length();
        //总长度
        int allLen = wordLen * wordNum;

        HashMap<String, Integer> allowWords = new HashMap<>();
        //将单词存入hash表中
        for (String word : words) {
            int value = allowWords.getOrDefault(word, 0);
            allowWords.put(word, value + 1);
        }
        //遍历字符串，直到字符串长度减去所以单词长度的差值为止
        for (int i=0; i<s.length() - allLen + 1; i++) {
            //截取字符串中，长度等于单词长度的字符串
            String tmp = s.substring(i, i+allLen);
            Map<String, Integer> has_map = new HashMap<>();
            //遍历上述截取的字符串，从字符串中再截取单词，放入临时map中
            for (int j =0; j<allLen; j+=wordLen) {
                String word = tmp.substring(j, j+wordLen);
                has_map.put(word, has_map.getOrDefault(word, 0) + 1);
            }
            //如果两个map相同，则记录开始的位置
            if (allowWords.equals(has_map)) {
                res.add(i);
            }
        }

        return res;
    }

    /**
     * 使用滑动窗口的方式来解决
     */
    public List<Integer> findSubstring_2(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int wordNum = words.length;
        if (wordNum == 0) {
            return res;
        }

        int wordLen = words[0].length();
        int allLen = wordNum * wordLen;

        //保存单词和它出现的次数
        Map<String, Integer> word_map = new HashMap<>();
        for (String word : words) {
            word_map.put(word, word_map.getOrDefault(word, 0) + 1);
        }

        // 只讨论从0，1，...， oneLen-1 开始的子串情况，
        //下标为0时，滑块判定的数据为 0， len , 2 * len, 3*len....
       // 下标为1时，滑块判定的数据为 1，len +1, 2 *len+1 ,3*len+1...
        // 每次进行匹配的窗口大小为 wordsLen，每次后移一个单词长度，由左右窗口维持当前窗口位置
        for (int i=0; i<wordLen; i++) {
            //左右窗口
            int left=i, right=i, count=0;
            //统计每个复合要求的word，即word记录到
            Map<String,Integer> has_map = new HashMap<>();
            //右窗口不能超出主字符串的长度
            while (right + wordLen <= s.length()) {
                //截取一个单词
                String word = s.substring(right, right+wordLen);
                //窗口右移
                right += wordLen;
                //words[]中没有这个单词，那么当前窗口肯定匹配失败，直接右移到这个单词后面
                if (!word_map.containsKey(word)) {
                    count = 0;
                    left = right;
                    has_map.clear();
                } else {
                    // 统计当前子串中这个单词出现的次数
                    has_map.put(word, has_map.getOrDefault(word, 0) + 1);
                    count++;
                    // 如果这个单词出现的次数大于words[]中它对应的次数，又由于每次匹配和words长度相等的子串
                    // 如 ["foo","bar","foo","the"]  "| foobarfoobar| foothe"
                    // 第二个bar虽然是words[]中的单词，但是次数抄了，那么右移一个单词长度后 "|barfoobarfoo|the"
                    // bar还是不符合，所以直接从这个不符合的bar之后开始匹配，也就是将这个不符合的bar和它之前的单词(串)全移出去
                    while (has_map.getOrDefault(word, 0) > word_map.getOrDefault(word, 0)) {
                        // 从当前窗口map中删除从左窗口开始到数量超限的所有单词(次数减一)
                        String tmp_word = s.substring(left, left+wordLen);
                        count--;
                        has_map.put(tmp_word, has_map.getOrDefault(tmp_word, 0) - 1);
                        //窗口右移
                        left += wordLen;
                    }
                    if (count == wordNum) {
                        res.add(left);
                    }
                }

            }
        }
        return res;
    }
}
