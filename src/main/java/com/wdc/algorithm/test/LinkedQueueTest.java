package com.wdc.algorithm.test;

import com.wdc.algorithm.queue.LinkedQueue;

/**
 * @author wendongchao
 * @ClassName LinkedQueueTest
 * @Date 2022/2/23 10:51
 */
public class LinkedQueueTest {
    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
        queue.put(1);
        queue.put(2);
        queue.put(4);
        queue.put(3);
        queue.put(0);
        System.out.println(queue);
        System.out.println("\n ------------------- \n");


        queue.pop();
        System.out.println(queue);
        System.out.println("\n ------------------- \n");


        System.out.println(queue.peek());
        queue.put(121);
        System.out.println(queue);

    }
}
