package com.wdc.leetcode.pointer;

/**
 * 反转字符串中的元音字母
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 *
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
 * @auther: dongchao
 * @data: 2022/10/11 13:46
 */
public class reverseVowels {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(reverseVowels(s));
    }

    /*
    反转字符串中的元音字母
    双指针（首尾指针）
     */
    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();

        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            if (!checkChar(chars[i])) {
                i++;
            } else if (!checkChar(chars[j])) {
                j--;
            } else {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }
        return new String(chars);
    }

    public static boolean checkChar(char a) {
        if ('a' == a || 'e' == a || 'i' == a || 'o' == a || 'u' == a || 'A' == a || 'E' == a || 'I' == a || 'O' == a || 'U' == a) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
