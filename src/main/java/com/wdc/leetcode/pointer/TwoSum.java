package com.wdc.leetcode.pointer;

/**
 * 两数之和
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
    双指针
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
    二分法
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
