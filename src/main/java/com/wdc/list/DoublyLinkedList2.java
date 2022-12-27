package com.wdc.list;

import lombok.Data;

/**
 * 双链表
 * @author dongchao
 * @time 2022-05-22 16:47
 */
@Data
public class DoublyLinkedList2<E> {
    private DoublyNode2<E> head;// 头节点
    private int size;

    public DoublyLinkedList2() {
        size = 0;
        this.head = new DoublyNode2<E>(null);
    }

    /**
     * 输出链表
     */
    public void print() {
        DoublyNode2<E> cur = head.next;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * 判断链表是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加节点，并返回该节点
     * @param node
     * @return
     */
    public DoublyNode2<E> add(DoublyNode2<E> node) {
        if (isEmpty()) {
            head = node;
            size++;
            return head;
        }
        DoublyNode2<E> cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
        node.prev = cur;
        size++;
        return node;
    }

    /**
     * 扁平化多级双向链表
     * @param head
     * @return
     */
    public DoublyNode2<Integer> flatten(DoublyNode2<Integer> head) {
        if (head == null) return null;
        DoublyNode2<Integer> cur = head;
        while (cur != null) {
            if (cur.child != null) {
                DoublyNode2<Integer> temp = cur.next;
                DoublyNode2<Integer> child = flatten(cur.child);
                DoublyNode2<Integer> childEnd = getTail(child);

                childEnd.next = cur.next;
                child.prev = cur;
                if (cur.next != null) {
                    cur.next.prev = childEnd;
                }
                cur.next = child;
                cur.child = null;// 子节点设置为空
                cur = temp;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public DoublyNode2<Integer> getTail(DoublyNode2<Integer> node) {
        while (node != null && node.next != null) {
            node = node.next;
        }
        return node;
    }




}
