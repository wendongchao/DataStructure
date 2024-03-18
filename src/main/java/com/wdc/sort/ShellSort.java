package com.wdc.sort;

/**
 * Title: 希尔排序
 * Description: 分别对间隔为gap的gap个子序列进行直接插入排序，不断缩小gap,直至为 1
 * 希尔排序的核心在于间隔序列的设定。既可以提前设定好间隔序列，也可以动态的定义间隔序列。
 * 刚开始时，gap较大，每个子序列元素较少，排序速度较快；
 * 待到排序后期，gap变小，每个子序列元素较多，但大部分元素基本有序，所以排序速度仍较快。
 * 时间复杂度：O(n) ~ O(n^2)
 * 空间复杂度：O(1)
 * 稳    定   性：不稳定
 * 内部排序(在排序过程中数据元素完全在内存)
 *
 * @author wendongchao
 * @ClassName ShellSort
 * @Date 2022/2/23 10:15
 */
public class ShellSort {

    public static void main(String[] args) {
        int arr[] = {2, 1, 3, 6, 4, 7, 5, 8, 9};
        shellSort(arr);
    }

    /**
     * 步骤1：先选定一个整数，把待排序的记录分为多个组gap。
     * 步骤2：所有距离为gap的倍数的记录放在同一个组中，然后对每个组内的元素进行直接插入排序。
     * 步骤3：重复步骤2，直到gap=1，此时所有元素都在同一组中，就是完全有序的，排序结束。
     *
     * @param target
     * @return int[]
     * @author dongchao
     * @date 2024/3/15 14:38
     */
    public static int[] shellSort(int[] target) {
        if (target == null || target.length < 2) {
            return target;
        }

        int gap = target.length;       // gap个大小为gap的子序列
        while (gap > 1) {
            gap = gap / 3 + 1;     // 不断缩小gap直至为1
            for (int i = gap; i < target.length; i++) {   // 对每个子序列进行直接插入排序
                if (target[i] < target[i - gap]) {
                    int j = i - gap;
                    int temp = target[i];         // 待插入值
                    while (j >= 0 && target[j] > temp) {  // 向前比较的终止条件
                        target[j + gap] = target[j];         // 后移元素
                        j = j - gap;          // 再比较前一个元素
                    }
                    target[j + gap] = temp;         // 将待插入值插入合适的位置
                }
            }
        }

        return target;
    }
}
