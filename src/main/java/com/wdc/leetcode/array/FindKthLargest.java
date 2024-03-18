package com.wdc.leetcode.array;

import com.wdc.sort.QuickSort;

/**
 * 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * @auther: dongchao
 * @data: 2022/9/28 16:19
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(arr, 4));
        System.out.println(quickSort(arr, 4));
    }

    /**
     * 解决思路：快排
     * @author dongchao
     * @date 2022/9/28 18:24
     */
    public static int quickSort(int[] nums, int k) {
        int len = nums.length;
        // 从小到大
        QuickSort.quickSort(nums,0,len-1);
        return nums[len-k];
    }


    /**
     * 解决思路：构建最小堆
     * @author dongchao
     * @date 2022/9/28 16:22
     */
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
//        HeapSortMin.buildMinHeap(nums);

        int size = nums.length;

        // 固定最小值，数组从大到小
        while (size > 1) {
//            HeapSortMin.swap(nums,0,size-1);
            size--;
            // 构建最小堆
//            HeapSortMin.heapify(nums,0,size);
        }
        // 生成的数组：从大到小
        return nums[k-1];
    }

}
