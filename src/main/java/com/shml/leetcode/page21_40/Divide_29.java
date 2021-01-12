package com.shml.leetcode.page21_40;

/**
 * ### [29\. 两数相除](https://leetcode-cn.com/problems/divide-two-integers/)
 *
 * Difficulty: **中等**
 *
 * 给定两个整数，被除数 `dividend` 和除数 `divisor`。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 `dividend` 除以除数 `divisor` 得到的商。
 * 整数除法的结果应当截去（`truncate`）其小数部分，例如：`truncate(8.345) = 8` 以及 `truncate(-2.7335) = -2`
 *
 * **示例 1:**
 * ```
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * ```
 *
 * **示例 2:**
 * ```
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 * ```
 * **提示：**
 * *   被除数和除数均为 32 位有符号整数。
 * *   除数不为 0。
 * *   假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2<sup>31</sup>,  2<sup>31 </sup>− 1]。本题中，如果除法结果溢出，则返回 2<sup>31 </sup>− 1。
 */
public class Divide_29 {

    public static void main(String[] args) {
        int ret = divide(11,3);
        System.out.println(ret);
    }

    /**
     * 解题思路：
     * 比如 10 和3,因为10>3×2^0，10>3×2^1，10<3×2^2=12
     * 所以3×2^1=6<10<3×2^2=12 所以可以得到结果就是10-3*2^1=4>3,有两个3
     * 被除数10-6=4大于3，4-3=1 有一个3
     * 被除数1小于3，结束
     * 所以结果是2+1=3；
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        //判断结果的正负号
        boolean sign = (dividend > 0) ^ (divisor > 0);

        int result = 0;
        //转换为负数
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }

        while (dividend <= divisor) {
            int temp_result = -1;
            int temp_divisor = divisor;
            //a = b0*2^n + b1*2^(n-1) + ... + n
            while (dividend <= (temp_divisor << 1)) {
                if (temp_divisor <= (Integer.MIN_VALUE >> 1))
                    break;
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }

        //判断正负号
        if (!sign) {
            if (result <= Integer.MIN_VALUE)
                return Integer.MAX_VALUE;
            result = -result;
        }
        return result;

    }
}
