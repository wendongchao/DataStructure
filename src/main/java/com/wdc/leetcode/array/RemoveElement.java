package com.wdc.leetcode.array;

/**
 * Titile: 移除重复的元素
 *
 *
 * @auther dongchao
 * @time 2022/9/26 17:52
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        System.out.println(removeElement(arr, 3));
        System.out.println();
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
