package com.wdc.list;

import lombok.Data;

/**
 * 双向链表节点
 * @author dongchao
 * @time 2022-05-15 23:23
 */
@Data
public class DoublyNode2<T> {
    DoublyNode2<T> prev;// 前驱
    T data;// 数据
    DoublyNode2<T> next;// 后置
    DoublyNode2<T> child;// child

    public DoublyNode2(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }

}
