package com.shml.leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 */
public class LongestPalindrome_5 {

    /**
     * 使用动态规划算法，还可以使用Matcher算法，这里推荐使用动态规划算法
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {

        int len = s.length();
        if (len <= 1) {
            return s;
        }

        /**
         * 如果dp[i,r]=true,那么dp[i+1, r-1]也一定为true
         *
         * 但是[i+1, r-1]至少有两个元素才有判断的必要
         *
         * 等价于 i+1 < r-1, 即：r-i > 2
         */

        int longestPalindrome = 1;
        String longestPalindromeStr = s.substring(0, 1);

        boolean[][] dp = new boolean[len][len];

        for (int i=1; i<len; i++) {
            for (int j=0; j<i; j++) {

                if (s.charAt(i)==s.charAt(j) && (i-j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > longestPalindrome) {
                        longestPalindrome = i - j + 1;
                        longestPalindromeStr = s.substring(j, i + 1);

                    }

                }
            }

        }

        return longestPalindromeStr;


    }


    /**
     * 用分隔符分割字符串
     */
    private String generateSDivided(String s, char divide) {
        int len = s.length();

        if (s.indexOf(divide) != -1) {
            throw new RuntimeException("分割符在字符串中已经存在！");
        }

        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(divide);
        for (int i=0; i<len; i++) {
            sBuilder.append(s.charAt(i)).append(divide);
        }

        return sBuilder.toString();
    }


    /**
     * matcher算法实现
     */
    public String longestPalindrome_Matcher(String s) {

        int len = s.length();
        if (len == 0) {
            return "";
        }

        String sDivided = generateSDivided(s,'#');

        int slen = sDivided.length();

        int[] p = new int[slen];

        int id = 0, mx = 0;

        int retLen = 1;

        String result = s.substring(0, 1);

        for (int i=0; i<slen; i++) {

            if (i < mx) {

                p[i] = Integer.min(p[2 * id - i], mx - i);

            } else {
                if (i > mx) {
                    throw new RuntimeException("error");
                }
                p[i] = 1;

            }

            // 老老实实去匹配，看新的字符
            while (i - p[i] >= 0 && i + p[i] < slen && sDivided.charAt(i - p[i]) == sDivided.charAt(i + p[i])) {
                p[i]++;
            }
            // 我们想象 mx 的定义，它是遍历过的 i 的 i + p[i] 的最大者
            // 写到这里，我们发现，如果 mx 的值越大，
            // 进入上面 i < mx 的判断的可能性就越大，这样就可以重复利用之前判断过的回文信息了
            if (i + p[i] > mx) {
                mx = i + p[i];
                id = i;
            }

            if (p[i] - 1 > retLen) {
                retLen = p[i] - 1;
                result = sDivided.substring(i - p[i] + 1, i + p[i]).replace("#", "");
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
