package com.wdc.structure.list.list2;

/**
 * 双向链表节点
 * @author dongchao
 * @time 2022-07-09 10:33
 */
public class DoublyNode {
    int data;
    DoublyNode prev;// 前驱
    DoublyNode next;// 后继

    public DoublyNode(int data) {
        this.data = data;
    }
}
