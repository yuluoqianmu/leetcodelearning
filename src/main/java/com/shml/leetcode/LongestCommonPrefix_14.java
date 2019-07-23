package com.shml.leetcode;


/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 */
public class LongestCommonPrefix_14 {

    /**
     * 水平扫描
     * @param strs
     * @return
     */
    public static String longestCommonPrefix_1(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        String perfix = strs[0];

        for (int i=1; i<strs.length; i++) {

            while (strs[i].indexOf(perfix) != 0) {

                perfix = perfix.substring(0, perfix.length() - 1);

                if (perfix.isEmpty()) {

                    return "";
                }

            }
        }

        return perfix;
    }


    /**
     * 垂直比较每一列
     * @param strs
     * @return
     */
    public static String longestCommonPrefix_2 (String[] strs) {

        if (strs == null || strs.length==0) {
            return "";
        }

        for (int i=0; i<strs[0].length(); i++) {

            char c = strs[0].charAt(i);

            for (int j=1; j<strs.length; j++) {

                if (i==strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    /**
     * trie树法
     */
    public String longestCommonPrefix_3 (String q, String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        Trie trie = new Trie();

        for (int i=1; i<strs.length; i++) {
            trie.insert(strs[i]);
        }

        return trie.searchLongestPrefix(q);
    }


    class TrieNode {

        //子节点的链接数组
        private TrieNode[] links;
        //记录26个小写字母
        private final int R = 26;
        //非空子节点的数量
        private int size;

        private boolean isEnd;

        public void put (char ch, TrieNode node) {
            links[ch - 'a'] = node;
            size++;
        }

        public int getLinks () {
            return size;
        }

        public boolean containsKey (char key) {
            return links[key - 'a'] != null;
        }

        public TrieNode get (char key) {
            return links[key - 'a'];
        }

        public void setEnd () {
            isEnd = true;
        }

        public boolean isEnd () {
            return isEnd;
        }

    }

    class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        private String searchLongestPrefix (String word) {

            TrieNode node = root;

            StringBuilder prefix = new StringBuilder();

            for (int i = 0; i < word.length(); i++) {

                char curLetter = word.charAt(i);

                if (node.containsKey(curLetter) && (node.getLinks() == 1) && !node.isEnd) {

                    prefix.append(curLetter);
                    node = node.get(curLetter);

                } else {
                    return prefix.toString();
                }

            }

            return prefix.toString();
        }

        public void insert(String word) {
            TrieNode node = root;

            for (int i=0; i<word.length(); i++) {
                char curChar = word.charAt(i);

                if (!node.containsKey(curChar)) {
                    node.put(curChar, new TrieNode());
                }

                node = node.get(curChar);

            }
            node.setEnd();
        }

    }



    /**
     * 分治法
     * @param strs
     * @return
     */
    public static String longestCommonPrefix_4(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        return longestCommonPrefix(strs, 0, strs.length -1);
    }

    public static String longestCommonPrefix(String[] strs, int left, int right) {

        if (left == right) {
            return strs[left];
        } else {

            int mid = (left + right) / 2;
            String lcpLeft = longestCommonPrefix(strs, left, mid);
            String lcpright = longestCommonPrefix(strs, mid + 1, right);
            return commonPrefix(lcpLeft, lcpright);
        }

    }

    public static String commonPrefix(String left, String right) {

        int min = Math.min(left.length(), right.length());

        for (int i=0; i<min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }

        return left.substring(0, min);
    }


    /**
     * 二分查找法
     * @param strs
     * @return
     */
    public static String longestCommonPrefix_5(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        int minLen = Integer.MAX_VALUE;

        for (String str : strs) {

            minLen = Math.min(minLen, str.length());
        }

        int low = 1, high = minLen;

        while (low < high) {

            int mid = (low + high) / 2;

            if (isCommonPrefix(strs, mid)) {

                low = mid + 1;

            } else {

                high = mid - 1;

            }

        }
        return strs[0].substring(0, (low + high) / 2);
    }

    public static boolean isCommonPrefix(String[] strs, int len) {

        String temp = strs[0].substring(0, len);

        for (int i = 1; i < strs.length; i++) {

            if (!strs[i].startsWith(temp)) {
                 return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        String[] strs = new String[]{"flower","flow","flight"};

        System.out.println(longestCommonPrefix_1(strs));

    }
}
