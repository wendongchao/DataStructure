package com.wdc.leetcode.array;

/**
 * Titile: 移动零 Description:
 *
 * @auther dongchao
 * @time 2022/9/26 17:24
 */
public class MoveZero {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        System.out.print(arr);
        System.out.println();
    }

    /**
     * 给定一个数组，把其中的0，移动到末尾，不改变原来数值顺序
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    public static void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                index++;
            } else if (index != 0) { // 有几个0，那么就往前走几步
                nums[i - index] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
