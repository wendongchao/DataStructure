package com.wdc.structure.list;

/**
 * 双链表
 * @author dongchao
 * @time 2022-05-22 16:47
 */
public class DoublyLinkedList<E> {

    /**
     * 链表长度
     * @param node
     * @return
     */
    public int getLength(DoublyNode<E> node) {
        if (node == null) {
            return 0;
        }
        int length = 0;
        while (node.next != null) {
            node = node.next;
            length++;
        }
        return length;
    }

}
