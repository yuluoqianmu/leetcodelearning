package com.shml.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 */
public class ConvertStr_6 {

    //numRows表示行数
    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        //
        int len = Math.min(s.length(), numRows);

        for (int i=0; i<len; i++) {
            rows.add(new StringBuilder());
        }

        //当前行
        int curRow = 0;
        //是否向下移动
        boolean goDown = false;

        for (char c : s.toCharArray()) {
            //
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow==numRows - 1) {
                goDown = !goDown;
            }
            //curRow += goDown ? 1 : -1;
            if (goDown)
                curRow = curRow + 1;
            else
                curRow = curRow - 1;

        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder build : rows) {
            ret.append(build);
        }

        return ret.toString();


    }

    public static void main(String[] args) {

    }
}
