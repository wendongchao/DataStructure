package com.wdc.leetcode.pointer;

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
        int[] twoSum = twoSum2(numbers, 9);
        System.out.println(twoSum);
    }

    /*
    双指针：
        们首先判断首尾两项的和是不是 target，如果比 target 小，那么我们左边 (i)+1 位置的数（比左边位置的数大）再和右相相加，
        继续判断。如果比 target 大，那么我们右边 (j)-1 位置的数（比右边位置的数小）再和左相相加，
        继续判断。我们通过这样不断放缩的过程，就可以在 O(n) 的时间复杂度内找到对应的坐标位置。
     */
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;
        while (j>i) {
            if (numbers[i]+numbers[j] == target) {
                return new int[]{i+1,j+1};
            } else if (numbers[i]+numbers[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{-1,-1};
    }

    /*
    二分法：
        遍历每个 nums[i]，在剩余数组中查找 target-nums[i] 的值，时间复杂度为 O(n log n)。
     */
    public static int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int low = i + 1, high = numbers.length - 1;
            while (high >= low) {
                int mid = (low + high) / 2;
                if (numbers[i] + numbers[mid] == target) {
                    return new int[]{i+1,mid+1};
                } else if (numbers[i] + numbers[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1,-1};
    }

}
