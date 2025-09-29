package com.shml.leetcode.page700_750;

import java.util.HashMap;
import java.util.Map;

/**
 * 京东面试题
 * // 题目说明：发票打印，最大999，最多小数点后2位
 * //编写时长：25分钟。
 * // 输入：133 输出： 一百三十三元
 * // 输入：324.56 输出： 三百二十四元五角六分
 */
public class MoneyChange {
    public static void main(String[] args) {

    printNovice("324.56");
    }


    public static void printNovice(String str) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "一");
        map.put(2, "二");
        map.put(3, "三");
        map.put(4, "四");
        map.put(5, "五");
        map.put(6, "六");
        map.put(7, "七");
        map.put(8, "八");
        map.put(9, "九");
        map.put(10, "十");
        map.put(100, "百");
        map.put(0, "元");

        String[] strs = str.split("\\.");
        String str1 = strs[0];
        Integer num1 = Integer.parseInt(str1);
        StringBuilder sb = new StringBuilder();
        int tmp = num1 / 100;
        if (tmp > 0) {
            sb.append(map.get(tmp)).append("百");
        }

        num1 = num1 % 100;
        int tmp2 = num1 / 10;
        if (tmp2 > 0) {
            sb.append(map.get(tmp2)).append("十");
        }
        num1 = num1 % 10;
        if (num1 > 0) {
            sb.append(map.get(num1)).append("元");
        } else {
            sb.append("元");
        }

        String str2 = strs[1];
        Integer num2 = Integer.parseInt(str2);

        int div = num2 / 10;
        if (div > 0) {
            sb.append(map.get(div)).append("角");
        }
        num2 = num2 % 10;
        if (num2 > 0) {
            sb.append(map.get(num2)).append("分");
        }

        System.out.println(sb.toString());
    }
}
