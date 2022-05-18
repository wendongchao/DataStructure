package com.wdc.structure.list;

/**
 * 单链表
 * @author dongchao
 * @time 2022-05-18 22:36
 */
public class SingleLinkedList<E> {
    private SingleNode<E> head; // 链表表头
    private int size; // 链表大小

    // 初始化头节点
    public SingleLinkedList() {
        head = new SingleNode<E>(null);
    }
    // 获取头节点
    public SingleNode<E> getHead() {
        return head;
    }
    // 获取链表长度
    public int size(){
        return size;
    }
    // 判断链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }
}
