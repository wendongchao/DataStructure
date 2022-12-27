package com.wdc.list;

/**
 * 双链表
 * @author dongchao
 * @time 2022-05-22 16:47
 */
public class DoublyLinkedList<E> {
    private DoublyNode<E> head;// 头节点
    private DoublyNode<E> tail;// 尾节点
    private int size;

    public DoublyLinkedList() {
        size = 0;
        this.head = new DoublyNode<E>(null);
        this.tail = new DoublyNode<E>(null);
    }

    /**
     * 获取头节点
     * @return
     */
    public DoublyNode<E> getHead() {
        return head;
    }

    /**
     * 获取链表长度
     * @return
     */
    public int getSize() {
        return size;
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
    public DoublyNode<E> add(DoublyNode<E> node) {
        if (isEmpty()) {
            head = node;
            return head;
        }
        DoublyNode<E> cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
        node.prev = cur;
        size++;

        return node;
    }

    /**
     * 输出链表
     */
    public void print() {
        DoublyNode<E> cur = head.next;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

    public E get(int index) throws Exception {
        if (index > size - 1 || index < 0) {
            throw new Exception("超出范围...");
        }
        DoublyNode<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = head.next;
        }
        return cur.data;
    }

    /**
     * 添加头节点
     * @param data
     * @return
     */
    public void addAtHead(E data) {
        DoublyNode<E> node = new DoublyNode<E>(data);
        if (isEmpty()) {
            head.next = node;
            tail.prev = node;
            return;
        }
        DoublyNode<E> cur = head;
        node.next = cur;
        cur.prev = node;
        head = node;
        size++;
    }

    /**
     * 添加节点到末尾
     * @param data
     * @return
     */
    public void addAtTail(E data) {
        DoublyNode<E> node = new DoublyNode<E>(data);
        if (isEmpty()) {
            head.next = node;
            tail.prev = node;
            return;
        }
        DoublyNode<E> cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
        node.prev = cur;
        size++;
    }

    /**
     * 指定位置添加节点
     * index > size:不添加
     * index < 0:头节点
     * index = size:末尾
     * @param index
     * @param data
     */
    public void addAtIndex(int index, E data) {
        if (index > size) {
            return;
        }

        if (index < 0) {
            addAtTail(data);
        }
        DoublyNode<E> node = new DoublyNode<E>(data);
        DoublyNode<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        DoublyNode<E> temp = cur.next;
        cur.next = node;
        node.prev = cur;
        if (temp != null) {
            node.next = temp;
            temp.prev = node;
        }
    }

    public void deleteAtIndex(int index) throws Exception {
        if (index > size -1 || index < 0) {
            throw new Exception("超出范围...");
        }
        DoublyNode<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        cur.next.prev = cur;
    }

}
