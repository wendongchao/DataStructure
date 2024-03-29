package com.wdc.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * Title: 交换排序中的冒泡排序 ，一般情形下指的是优化后的冒泡排序，最多进行n-1次比较
 * Description:因为越大的元素会经由交换慢慢"浮"到数列的顶端(最后位置)，最大的数最后才确定下来，所以称为冒泡排序
 * 时间复杂度：最好情形O(n)，平均情形O(n^2)，最差情形O(n^2)
 * 空间复杂度：O(1)
 * 稳 定 性：稳定
 * 内部排序(在排序过程中数据元素完全在内存)
 *
 * @author wendongchao
 * @ClassName BubbleSort
 * @Date 2022/2/23 10:02
 */
public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, 20};
        System.out.printf("排序后的数组", bubbleSort(arr));
        System.out.printf("优化排序后的数组", optimizeBubbleSort(arr));
    }

    /**
     * 冒泡排序(共进行n-1次比较)
     * 时间复杂度：(n-1)*(n-1) -> n^2
     *
     * @author rico
     */
    public static int[] bubbleSort(int[] target) {
        if (target == null || target.length < 2) {
            return target;
        }
        int n = target.length;
        // 最多需要进行n-1次，每一次将比较小的元素移到前面，比较大的元素自然就逐渐沉到最后面了，这就是冒泡
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (target[j] < target[j - 1]) {// 从后往前比较
                    int temp = target[j];
                    target[j] = target[j - 1];
                    target[j - 1] = temp;
                }
            }
            System.out.println(Arrays.toString(target));
        }
        return target;
    }

    /**
     * 优化冒泡排序
     *
     * @author rico
     */
    public static int[] optimizeBubbleSort(int[] target) {
        if (target == null || target.length < 2) {
            return target;
        }
        int n = target.length;
        // 最多需要进行n-1次，每一次将比较小的元素移到前面，比较大的元素自然就逐渐沉到最后面了，这就是冒泡
        for (int i = 0; i < n - 1; i++) {
            boolean exchange = false;// 判断是否有进行比较的标志
            for (int j = n - 1; j > i; j--) {
                if (target[j] < target[j - 1]) {// 从后往前比较
                    int temp = target[j];
                    target[j] = target[j - 1];
                    target[j - 1] = temp;
                    exchange = true;
                }
            }
            System.out.println(Arrays.toString(target));
            if (!exchange) {// 已经没有比较元素了，就直接返回
                return target;
            }
        }
        return target;
    }
}
