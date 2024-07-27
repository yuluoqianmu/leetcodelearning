package com.shml.leetcode.page100_120;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串。返回 s 所有可能的分割方案。
 *
 * 示例 1：
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 *
 * 示例 2：
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 * 提示：
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 */
public class Partition_131 {

    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    String str;

    public static void main(String[] args) {
        System.out.println(staticMethod(new Partition_131()));
    }

    public static List<List<String>> staticMethod(Partition_131 partition) {
       return partition.partition("aab");
    }


    public List<List<String>> partition(String s) {
        this.str = s;
        dfs(0);
        return res;
    }

    private void dfs(int start) {

        if (start == str.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < str.length(); i++) {
            if (isValid(start, i)) {
                path.add(str.substring(start, i+1));
                dfs(i+1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isValid(int left, int right) {
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

}
