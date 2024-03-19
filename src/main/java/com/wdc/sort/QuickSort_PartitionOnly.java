package com.wdc.sort;

import java.util.Arrays;

/**
 * Title:快速排序的变形
 * Description: 本质上不断调用经典快排的划分算法
 * 时间复杂度：O(n^2)
 *
 * @author wendongchao
 * @ClassName QuickSort_PartitionOnly
 * @Date 2022/2/23 10:14
 */
public class QuickSort_PartitionOnly {
    /**
     * @param array
     * @description 依次以数组中的每个元素为基准点进行划分，
     * 直到遍历所有元素都
     * @author rico
     */
    public void quicksort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            // 以下是快排的划分算法
            int base_index = 0;
            int base = array[i];
            base_index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] <= base) {
                    base_index++;
                    if (base_index != j) {
                        int temp = array[base_index];
                        array[base_index] = array[j];
                        array[j] = temp;
                    }
                }
            }
            array[i] = array[base_index];
            array[base_index] = base;
            System.out.println(Arrays.toString(array));
        }

    }

    public static void main(String[] args) {
//		int[] array = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
        int[] array = {1, 2, 3, 5, 0, 4, 9, 2, 6};
        new QuickSort_PartitionOnly().quicksort(array);
    }
}
