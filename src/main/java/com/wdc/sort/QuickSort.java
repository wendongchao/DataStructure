package com.wdc.sort;


import java.util.Arrays;

/**
 * Title: 快速排序
 * 填坑法
 * 交换指针
 * @author wendongchao
 * @ClassName QuickSort
 * @Date 2022/2/23 10:12
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4,7,6,5,3,2,8,1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    // 填坑法：递归实现
    public static int[] quickSort(int[] target, int startIndex, int endIndex) {
        if(endIndex > startIndex){     // 递归终止条件
            // 获取基准元素位置
            int pivot_index = partition(target,startIndex, endIndex);
            // 用分治法递归数列的两部分
            quickSort(target, startIndex, pivot_index-1);    // 对左边数列，不包含基准元素！
            quickSort(target, pivot_index+1, endIndex);   // 对右边数列，不包含基准元素！
        }
        return target;
    }

    // 获取基准元素
    public static int partition(int[] target, int startIndex, int endIndex){
        // 取第一个位置的元素为基准元素
        int pivot = target[startIndex];
        int left = startIndex;
        int right = endIndex;
        // 坑的位置，初始等于pivot的位置
        int index = startIndex;

        // 大循环在左右指针重合或者交错时结束
        while (right > left) {
            // right指针从右往左进行比较
            while (right >= left) {
                if (target[right] < pivot) {
                    target[left] = target[right];
                    index = right;
                    left++;
                    break;
                }
                right--;
            }
            // left指针从左往右进行比较
            while (right >= left) {
                if (target[left] > pivot) {
                    target[right] = target[left];
                    index = left;
                    right--;
                    break;
                }
                left++;
            }
        }
        target[index] = pivot;
        return index;
    }


}
