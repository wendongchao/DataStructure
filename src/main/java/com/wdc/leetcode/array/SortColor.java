package com.wdc.leetcode.array;

/**
 * @auther: dongchao
 * @data: 2022/9/27 18:23
 */
public class SortColor {
    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        sortColors(arr);
    }

    /**
     * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums，原地对它们进行排序，
     * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
     * @author dongchao
     * @date 2022/9/27 18:27
     */
    public static void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            } else if (nums[i] == 1) {
                one++;
            } else if (nums[i] == 2) {
                two++;
            }
        }
        for (int i = 0; i < zero; i++) {
            nums[i] = 0;
        }
        for (int i = zero; i < zero + one; i++) {
            nums[i] = 1;
        }
        for (int i = zero+one; i < zero+one+two; i++) {
            nums[i] = 2;
        }

    }
}
