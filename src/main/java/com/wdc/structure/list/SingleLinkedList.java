package com.wdc.structure.list;

/**
 * 单链表
 * @author dongchao
 * @time 2022-05-18 22:36
 */
public class SingleLinkedList<E> {
    private SingleNode<E> head; // 链表表头
    private int size; // 链表大小

    /**
     * 初始化头节点
     */
    public SingleLinkedList() {
        head = new SingleNode<E>(null);
    }

    /**
     * 获取头节点
     * @return
     */
    public SingleNode<E> getHead() {
        return head;
    }

    /**
     * 获取链表长度
     * @return
     */
    public int size(){
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
     * 输出链表
     */
    public void print() {
        SingleNode<E> cur = head.next;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * @description 从尾到头输出单链表(递归法)
     * @param head
     */
    public void reversePrint(SingleNode<E> head) {
        if (head.next != null) {
            reversePrint(head.next); // 不断"递去"
            System.out.print(head.next.data + " "); // "归来"开始打印
        }
    }

    /**
     * 添加节点，并返回该节点
     * @param node
     * @return
     */
    public SingleNode<E> add(SingleNode<E> node) {
        SingleNode<E> cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
        size++;
        return node;
    }

    /**
     * 添加头节点
     * @param node
     * @return
     */
    public SingleNode<E> addHead(SingleNode<E> node) {
        SingleNode<E> cur = head;
        SingleNode<E> temp = head.next;
        cur.next = node;
        node.next = temp;
        return node;
    }

    /**
     * 指定位置插入节点，并返回该节点
     * @param node
     * @param index
     * @return
     * @throws Exception
     */
    public SingleNode<E> addIndex(SingleNode<E> node, int index) throws Exception {
        if (index > size) {
            throw new Exception("超出范围...");
        }
        SingleNode<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        SingleNode<E> temp = cur.next;
        cur.next = node;
        node.next = temp;
        size++;
        return node;
    }

    /**
     * 指定位置删除节点
     * @param index
     * @return
     * @throws Exception
     */
    public E remove(int index) throws Exception {
        if (index > size - 1 || index < 0) {
            throw new Exception("超出范围...");
        }
        SingleNode<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        SingleNode<E> temp = cur.next;
        cur.next = temp.next;
        temp.next = null;
        size--;
        return temp.data;
    }

    /**
     * 获取索引位置的值
     * @param index
     * @return
     * @throws Exception
     */
    public E get(int index) throws Exception {
        if (index > size - 1 || index < 0) {
            throw new Exception("超出范围...");
        }
        SingleNode<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.data;
    }

    /**
     * 删除链表中的重复元素(外循环 + 内循环)
     * 时间复杂度：O(n^2)
     */
    public void removeDuplicateSingleNodes() {
        SingleNode<E> cur = head.next;
        while (cur != null) { // 外循环
            SingleNode<E> temp = cur;
            while (temp != null && temp.next != null) { // 内循环
                if (cur.data.equals(temp.next.data)) {
                    SingleNode<E> duplicateSingleNode = temp.next;// 重复节点
                    temp.next = duplicateSingleNode.next;
                    duplicateSingleNode.next = null;
                    size --;
                }
                temp = temp.next;
            }
            cur = cur.next;
        }
    }

    /**
     * 判断链表中是否有换
     * 双指针：快慢指针
     * @return
     */
    public boolean hasLoop() {
        SingleNode<E> index1 = head.next; // 慢指针
        SingleNode<E> index2 = head.next; // 快指针
        while (index2 != null && index2.next != null
                && index2.next.next != null) {
            index1 = index1.next;
            index2 = index2.next.next;
            if (index1 == index2) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断链表中是否有环，并返回进入环的节点
     *  有：返回进入环的节点
     *  无：返回null
     * @return
     */
    public SingleNode<E> detectCycle(){
        SingleNode<E> index1 = head.next; // 慢指针
        SingleNode<E> index2 = head.next; // 快指针
        while (index2 != null && index2.next != null
                && index2.next.next != null) {
            index1 = index1.next;
            index2 = index2.next.next;
            if (index1 == index2) {
               break;
            }
        }
        if (index2 == null || index2.next == null) {
            return null;
        }
        index2 = head;
        while (index1 != index2) {
            index1 = index1.next;
            index2 = index2.next;
        }
        return index2;
    }

    /**
     * 返回两链表的交点(若不相交，返回null)
     * @param list2
     * @return
     */
    public SingleNode<E> getIntersectionPoint(LinkedList<E> list2) {
        SingleNode<E> cur1 = head.next;   // 当前链表
        SingleNode<E> cur2 = list2.getHead().next;  // 目标链表
        while (cur1 != cur2) {
            cur1 = cur1 == null ? list2.getHead() : cur1.next;
            cur2 = cur2 == null ? head : cur2.next;
        }
        return cur1;
    }

    /**
     * 删除链表中倒数n的值
     * @param n
     * @return
     */
    public SingleNode<E> removeNthFromEnd(int n) throws Exception {
        if (n > size - 1 || n < 0) {
            throw new Exception("超出范围...");
        }
        SingleNode<E> index1 = head.next; // 慢指针
        SingleNode<E> index2 = head.next; // 快指针
        // index2移动n步
        for (int i = 0; i < n; i++) {
            index2 = index2.next;
        }
        // 如果index2为空，表示删除的是头结点
        if (index2 == null) {
            return head.next;
        }

        while (index2 != null){
            index1 = index1.next;
            index2 = index2.next;
        }
        //这里最终index1不是倒数第n个节点，他是倒数第n+1个节点，
        //他的下一个结点是倒数第n个节点,所以删除的是他的下一个结点
        index1.next = index1.next.next;
        return head;
    }

    /**
     *  反转链表
     */
    public void reverseLinkedList() {
        SingleNode<E> cur = head.next; // 原链表第一个元素
        SingleNode<E> pre = null; // 反转后的链表最后一个元素

        while (cur != null) { // 对原链表中的每个节点进行反转
            SingleNode<E> next = cur.next; // 记录当前节点的下一个节点
            cur.next = pre; // 当前节点指向反转后的链表
            pre = cur; // 更新反转后的链表
            cur = next; // 更新当前节点(移动到下一个节点)
        }
        head.next = pre; // 将原链表的头结点指向反转后的链表
    }



}
