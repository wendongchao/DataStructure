package com.wdc.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 * https://leetcode.cn/leetbook/read/array-and-string/c5tv3/
 * @auther: dongchao
 * @data: 2023/2/20 11:44
 */
public class MergeRange {

    public int[][] merge(int[][] intervals) {
        //1、对二维数组按照第一列升序排序
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        //2、进行合并数组
        List<int[]> list = new ArrayList<>();
        int term[] =intervals[0];//临时空间，1 判断是否需要合并集合，2 是否放入结果集
        for (int i = 1; i < intervals.length; i++) {
            if (term[1] >= intervals[i][0]) {
                term[1]=Math.max(term[1],intervals[i][1]);
            } else {
                list.add(term);
                term = intervals[i];
            }
        }
        list.add(term);
        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {

    }
}
