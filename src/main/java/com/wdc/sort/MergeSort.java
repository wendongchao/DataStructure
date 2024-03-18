package com.wdc.sort;

import java.util.Arrays;

/**
 * 归并排序：https://blog.csdn.net/justidle/article/details/104203958
 *
 * @author wendongchao
 * @ClassName MergeSort
 * @Date 2022/2/23 10:11
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] target = {21, 25, 49, 25, 16, 8, 31, 41};
        mergeSort(target, 0, target.length - 1);
        System.out.println(Arrays.toString(target));
    }

    /**
     * @param target 待排序序列
     * @param left   待排序序列起始位置
     * @param right  待排序序列终止位置
     * @description 归并排序算法(递归算法)：递去分解，归来合并
     */
    public static int[] mergeSort(int[] target, int left, int right) {
        if (left == right) {
            return new int[]{target[left]};
        }
        int mid = left + (right - left) / 2;
        int[] leftArray = mergeSort(target, left, mid);// 左有序数组
        int[] rightArray = mergeSort(target, mid + 1, right);// 右有序数组
        int newArray[] = new int[leftArray.length + rightArray.length];// 新有序数组
        int m = 0, i = 0, j = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {// 稳定性
                newArray[m++] = leftArray[i++];
            } else {
                newArray[m++] = rightArray[j++];
            }
        }
        while (i < leftArray.length) {// 未检查完，填充
            newArray[m++] = leftArray[i++];
        }
        while (j < rightArray.length) {// 未检查完，填充
            newArray[m++] = rightArray[j++];
        }
        return newArray;
    }

}
