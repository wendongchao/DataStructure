package com.wdc.leetcode.array;

/**
 * 寻找数组的中心索引
 * 给你一个整数数组nums ，请计算数组的 中心下标 。
 *
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 *
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 *
 * @auther: dongchao
 * @data: 2022/10/14 13:48
 */
public class PivotIndex {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(pivotIndex(nums));
    }

    /*
    思路：先计算总和，遍历计算left之和，根据索引把数组分成两个相等数之和，left*2+num[i]=sum
     */
    public static int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum == left*2+nums[i]) {
                return i;
            } else {
                left += nums[i];
            }
        }
        return -1;
    }

}
