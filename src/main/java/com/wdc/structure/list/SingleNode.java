package com.wdc.structure.list;

/**
 * 单向链表节点
 * @author dongchao
 * @time 2022-05-15 23:19
 */
public class SingleNode<T> {
    SingleNode<T> next;// 下一节点
    T data;// 当前数据

    /**
     * 构造一个新节点
     * @param data 元素数据
     */
    public SingleNode(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
