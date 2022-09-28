package com.wdc.leetcode.array;

/**
 * 删除重复项
 *  给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
 *  返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * @auther: dongchao
 * @data: 2022/9/27 11:37
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates2(arr));
    }

    /**
     * 删除重复项
     * @author dongchao
     * @date 2022/9/27 17:58
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[index] != nums[i]) {// 如果不相同，++，并往后一步
                nums[++index] = nums[i];
            }
        }
        return index+1;
    }

    /**
     * 删除重复项，保留重复2次的项
     * @author dongchao
     * @date 2022/9/27 17:59
     */
    public static int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 既然相同数字最多只能保存两个，又因为数组有序，相同的数字必然连续，
        // 所以只需判断数字与它相隔前两个位置的数字是否相同，相同则不存，不同才存
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (index < 2 || nums[index-2] != nums[i]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }


}
