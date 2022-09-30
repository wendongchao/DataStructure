package com.wdc.sort;

import java.util.Arrays;

/**
 * 小数堆：堆顶元素小于左右子节点
 * @auther: dongchao
 * @data: 2022/9/30 16:05
 */
public class HeapSortMin {
    public static void main(String[] args) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        buildMinHeap(arr);
        int size = arr.length;

        // 固定最小值，数组从大到小
        while (size > 1) {
            swap(arr,0,size-1);
            size--;
            // 构建最小堆
            heapify(arr,0,size);
        }
        System.out.println(Arrays.toString(arr));
    }

    // 构建最小堆，父节点小于左右子节点
    public static void buildMinHeap(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 当前索引
            int currentIndex = i;
            // 父索引
            int fatherIndex = (currentIndex - 1) / 2;
            // 因为构建最小堆，如果当前插入的值小于其父结点的值,则交换值，并且将索引指向父结点
            // 然后继续和上面的父结点值比较，直到不小于父结点，则退出循环
            while (nums[currentIndex] < nums[fatherIndex]) {
                // 交换当前结点与父结点的值
                swap(nums,currentIndex,fatherIndex);
                // 将当前索引指向父索引
                currentIndex = fatherIndex;
                // 重新计算当前索引的父索引
                fatherIndex = (currentIndex - 1) / 2;
            }
        }
    }

    // 将剩余的数构造成小根堆（通过顶端的数下降）
    // 把小堆数据排序
    public static void heapify(int[] nums, int index, int size) {
        int left = 2 * index + 1;// 左边节点
        int right = 2 * index + 2;// 右边节点
        while (left < size) {
            int leastIndex;
            // 判断孩子中较小的值的索引（要确保右孩子在size范围之内）
            if (right < size && nums[left] > nums[right]) {
                leastIndex = right;
            } else {
                leastIndex = left;
            }
            // 比较父结点的值与孩子中较小的值，并确定最小值的索引
            if (nums[index] < nums[leastIndex]) {
                leastIndex = index;
            }

            // 如果父结点索引是最小值的索引，那已经是小根堆了，则退出循环
            if (index == leastIndex) {
                break;
            }
            // 父结点不是最小值，与孩子中较小的值交换
            swap(nums,leastIndex,index);
            // 将索引指向孩子中较小的值的索引
            index = leastIndex;
            // 重新计算交换之后的孩子的索引
            left = 2 * index + 1;
            right = 2 * index + 2;
        }
    }

    // 交换
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
