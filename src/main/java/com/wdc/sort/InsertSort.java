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
//        insertSort(arr);
        binaryInsertSort(arr);
    }

    /**
     * 简单插入排序：一个数组，从第二位开始，与前面数据比较，并排序，一直到最后一位
     *
     * @param arr
     * @return
     */
    public static int[] insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int insertVal = 0;
        int insertIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];// 待插入的数
            insertIndex = i - 1;// 前一个数的下标
            // insertIndex >= 0，从右往左回退时不越界
            // insertVal < arr[insertIndex] 要插入的数据是否小于左边的数据
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

    /**
     * 折半插入排序，依赖于初始序列
     * 折半搜索出插入位置，并直接插入;与直接插入搜索的区别是，后者的搜索要快于顺序搜索
     * 时间复杂度：折半插入排序比直接插入排序明显减少了关键字之间的比较次数，但是移动次数是没有改变。所以，
     * 折半插入排序和插入排序的时间复杂度相同都是O（N^2），在减少了比较次数方面它确实相当优秀，所以该算法仍然比直接插入排序好。
     * 空间复杂度：O(1)
     * 稳    定   性：稳定
     * 内部排序(在排序过程中数据元素完全在内存)
     *
     * @param target
     * @return int[]
     * @author dongchao
     * @date 2024/3/15 11:25
     */
    public static int[] binaryInsertSort(int[] target) {
        if (target == null || target.length < 2) {
            return target;
        }
        for (int i = 1; i < target.length; i++) {
            int left = 0;
            int right = i - 1;
            int mid;// 中间值
            int temp = target[i];
            if (target[right] < temp) {
                continue;
            }
            // 当前值小于有序序列的最大值时，开始查找插入位置
            while (left <= right) {
                mid = (left + right) / 2;
                if (target[mid] < temp) {
                    left = mid + 1;    // 缩小插入区间，左->右
                } else if (target[mid] > temp) {
                    right = mid - 1;    // 缩小插入区间，从右->左
                } else {        // 待插入值与有序序列中的target[mid]相等，保证稳定性的处理
                    left = left + 1;
                }
            }

            // left及其后面的数据顺序向后移动，并在left位置插入
            for (int j = i; j > left; j--) {
                target[j] = target[j - 1];
            }
            target[left] = temp;
        }
        return target;
    }

}
