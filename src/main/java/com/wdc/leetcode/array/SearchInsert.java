package com.wdc.leetcode.array;

/**
 * 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * @auther: dongchao
 * @data: 2022/10/14 14:43
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert1(nums, 5));
        System.out.println(searchInsert2(nums, 5));
    }

    /*
    暴力法：
        1、数组中的值大于或等于target，直接return
        2、如果全部遍历完，证明target是最大的数，直接插入末尾
    缺点：数据较多时，没那么高效
     */
    public static int searchInsert1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target<=nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    /*
    二分法：
        1、left=0，right=nums.length,取mid为中间值
        2、如果nums[mid]==target,返回mid值，循环终止
        3、如果nums[mid]>target,就说明从mid到right之间的值都是“无用的”需要挪动right，
           而我们能知道的接近的一个无用的值是mid，因此right必须比mid还要小才行，也即是right=mid-1；
        4、同理，left=mid+1；
        5、一直循环，除非找到mid值或者发现target根本不在目标中，也就是已经完全循环了一遍(left>right),
           这时候的left的值就是最接近target但又大于target的值（可以拿0来举例自己画一遍过程），因此return left
     */
    public static int searchInsert2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int i = 0;
        int j = nums.length - 1;
        int mid = 0;
        while (i <= j) {
            mid = i + (j - i) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                j = mid - 1;
            } else if (target > nums[mid]) {
                i = mid + 1;
            }
        }
        return i;
    }

}
