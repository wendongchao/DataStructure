package com.wdc.leetcode.array;

/**
 * 合并两个数组 双指针
 * @auther: dongchao
 * @data: 2022/10/10 17:40
 */
public class Merge {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1,3,nums2,3);
        System.out.println(nums1);
    }

    /*
     尾插法：从尾部比较数据，并填写数据
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int end = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[end--] = nums1[i--];
            } else {
                nums1[end--] = nums2[j--];
            }
        }
    }
}
