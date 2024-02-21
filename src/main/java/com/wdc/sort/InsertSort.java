package com.wdc.sort;

/**
 * Titile: 插入排序
 * Description:
 *
 * @auther dongchao
 * @time 2022/9/21 22:13
 */
public class InsertSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 4, 20};
        insertSort(arr);
    }

    /**
     * 简单插入排序：一个数组，从第二位开始，与前面数据比较，并排序，一直到最后一位
     *
     * @param arr
     * @return
     */
    public static int[] insertSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];// 待插入的数
            insertIndex = i - 1;// 前一个数的下表
            // insertIndex >= 0，从右往左回退时不越界
            // insertVal < arr[insertIndex] 要插入的数据是否小于左的数据
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];// 左边的数据移动到右边
                insertIndex--;// 插入位置往左边移动
            }
            // 退出while循环，说明要插入的位置找到了
            // 如果插入的数据是当前位置，跳过
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
        return arr;
    }

}
