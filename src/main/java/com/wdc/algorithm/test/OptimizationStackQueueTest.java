package com.wdc.algorithm.test;

import com.wdc.algorithm.queue.OptimizationStackQueue;

/**
 * @author wendongchao
 * @ClassName OptimizationStackQueueTest
 * @Date 2022/2/23 10:52
 */
public class OptimizationStackQueueTest {
    public static void main(String[] args) {
        OptimizationStackQueue<Integer> queue = new OptimizationStackQueue<Integer>();
        queue.put(1);
        queue.put(3);
        queue.put(5);
        queue.put(2);
        queue.put(8);
        queue.put(6);
        System.out.println(queue);
        System.out.println("\n------------------\n");

        queue.pop();
        System.out.println(queue);
        System.out.println("\n------------------\n");

        queue.put(4);
        queue.put(5);
        System.out.println(queue);
        System.out.println("\n------------------\n");
    }
}
