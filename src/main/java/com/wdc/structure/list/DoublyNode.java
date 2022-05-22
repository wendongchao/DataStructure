package com.wdc.structure.list;

/**
 * 双向链表节点
 * @author dongchao
 * @time 2022-05-15 23:23
 */
public class DoublyNode<T> {
    DoublyNode<T> prev;// 前驱
    T data;// 数据
    DoublyNode<T> next;// 后置

    public DoublyNode(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
