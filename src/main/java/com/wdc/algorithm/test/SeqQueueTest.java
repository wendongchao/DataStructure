package com.wdc.algorithm.test;

import com.wdc.algorithm.queue.SeqQueue;

/**
 * @author wendongchao
 * @ClassName SeqQueueTest
 * @Date 2022/2/23 10:52
 */
public class SeqQueueTest {

    public static void main(String[] args) {

        SeqQueue<Integer> queue = new SeqQueue<Integer>(5);
        queue.put(1);
        queue.put(2);
        queue.put(3);
        queue.put(4);
        queue.put(3);
        queue.put(4);
        System.out.println(queue);
        System.out.println("\n----------------\n");

        queue.pop();
        System.out.println(queue);
        System.out.println("\n----------------\n");

        System.out.println(queue.peek());
        System.out.println(queue);
    }
}
