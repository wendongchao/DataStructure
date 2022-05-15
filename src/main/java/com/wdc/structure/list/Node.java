package com.wdc.structure.list;

/**
 * Title: 结点类
 * Description: 链表的基本元素
 * @author wendongchao
 * @ClassName Node
 * @Date 2022/2/23 10:20
 */
public class Node<T> {
    //包可见性
    Node<T> next;// 下一节点
    T data;// 当前数据

    /**
     * 构造一个新节点
     * @param data 元素数据
     */
    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
