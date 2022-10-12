package com.wdc.leetcode.pointer;

/**
 * 长度最小的子数组
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * @auther: dongchao
 * @data: 2022/10/11 17:08
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));
    }

    /*
    双指针，快慢指针
    窗口滑动：思路
    1、[left, right]闭区间为窗口区间，left = right = 0
    2、left固定，right递增，[left, right]符合条件（该题是区间和>=target）时，进行3
    3、right固定,left递增
        若区间满足更新条件区间和>=target 且区间长度更小，更新，增加left，
        若区间和小于target，进行2
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int len = nums.length;
        int count = len + 1;// 初始窗口大于数组长度
        int sum = 0;

        while (j < len) {
            sum += nums[j];
            if (sum >= target) {
                while (i <= j && sum >= target) {// 窗口满足，那么左侧移动，并比较
                    count = Math.min(count,j-i+1);
                    sum -= nums[i++];
                }
            }
            j++;
        }
        // 如果窗口一直未满足，那么返回0
        return count == len + 1 ? 0 : count;
    }

}
