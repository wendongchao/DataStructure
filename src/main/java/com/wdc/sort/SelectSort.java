package com.wdc.sort;

/**
 * Title: 选择排序
 * Description: 每次找到数组中当前排序范围中的最小值并与该范围中的第一个数字交换，同时缩小待排序数组的排序范围
 * 				时间复杂度：最好情形O(n^2)，平均情形O(n^2)，最差情形O(n^2)
 * 				空间复杂度：O(1)
 * 				稳    定   性：不稳定
 * 				内部排序(在排序过程中数据元素完全在内存)
 * @auther dongchao
 * @time 2022/9/21 21:41
 */
public class SelectSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, 20};
        selectSort(arr);
    }

    public static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {// 不用到最后一位
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {// 不用从第一位
                if (min > arr[j]) {// 寻找最小值，替换
                    min = arr[j];// 重置min
                    minIndex = j;// 重置minIndex
                }
            }

            // 与最小值交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        return arr;
    }
}
