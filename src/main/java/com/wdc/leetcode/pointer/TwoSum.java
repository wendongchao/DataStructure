package com.wdc.leetcode.pointer;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 给你一个下标从 1 开始的整数数组numbers ，该数组已按 非递减顺序排列 ，请你从数组中找出满足相加之和等于目标数target 的两个数。
 * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 *
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 *
 * @auther: dongchao
 * @data: 2022/10/10 18:03
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int[] twoSum = twoSum(numbers, 9);
        System.out.println(twoSum);
    }

    /*
    暴力枚举
     */
    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    /*
       hash
    */
    public static int[] twoSum2(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]),i};
            }
            map.put(numbers[i],i);
        }
        return new int[]{-1,-1};
    }

}
