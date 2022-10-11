package com.wdc.leetcode.pointer;

/**
 * 回文字符串：
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。
 * ASCII对照表：
 *  0-9：48-57
 *  A-Z：65-90
 *  a-z: 91-122
 *
 * @auther: dongchao
 * @data: 2022/10/11 11:19
 */
public class Palindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    /*
    验证回文串
    双指针（头尾指针）
     */
    public static boolean isPalindrome(String s) {
        String str = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();

        char[] chars = str.toCharArray();
        int i = 0;
        int j = chars.length-1;

        while (i < j) {
            if (chars[i] != chars[j]) {
                return Boolean.FALSE;
            }
            i++;
            j--;
        }
        return Boolean.TRUE;
    }
}
