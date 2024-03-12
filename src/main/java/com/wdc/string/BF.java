package com.wdc.string;

/**
 * @auther wendongchao
 * @date 2024/1/22 18:22
 **/
public class BF {

    public int strStr(String haystack, String needle) {
        int haylen = haystack.length();
        int needlen = needle.length();
        //特殊情况
        if (haylen < needlen) {
            return -1;
        }
        if (needlen == 0) {
            return 0;
        }
        //主串
        for (int i = 0; i < haylen - needlen + 1; ++i) {
            int j;
            //模式串
            for (j = 0; j < needlen; j++) {
                //不符合的情况，直接跳出，主串指针后移一位
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
            }
            //匹配成功
            if (j == needlen) {
                return i;
            }

        }
        return -1;
    }
}
