package com.wdc.list;

/**
 * 单向链表节点
 * @author dongchao
 * @time 2022-05-15 23:19
 */
public class SingleNode<T> {
    T data;// 当前数据
    SingleNode<T> next;// 下一节点

    public SingleNode(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
