package com.wdc.leetcode.pointer;

/**
 * 盛最多水的容器
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 *
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 思路：
 * 面积：短板的长度*短板与长板的距离
 * 判断容积的时候，因为只有短板才有影响，所以移动指针应该移动短板，因为移动长板时，有：
 *  如果长板变得比短板还短，那么容积显然减少。
 *  如果长板变得比短板长或相等，因为短板依旧未变。但距离减少，所以容积依旧减少。
 * 但是如果你移动短板的话，就会有容积增大的可能。
 * 正确性证明：https://leetcode.cn/problems/container-with-most-water/solution/container-with-most-water-shuang-zhi-zhen-fa-yi-do/
 *
 * @auther: dongchao
 * @data: 2022/10/11 16:03
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    /*
    双指针
     */
    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;

        while (i < j) {
            maxArea = Math.max(maxArea,Math.min(height[i],height[j]) * (j -i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}
