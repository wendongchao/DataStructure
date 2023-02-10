package com.wdc.list;

import java.util.List;

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

    // 输出链表
    public void print() {
        SingleNode<E> cur = head.next;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    // 从尾到头输出单链表(递归法)
    public void reversePrint(SingleNode<E> head) {
        if (head.next != null) {
            reversePrint(head.next); // 不断"递去"
            System.out.print(head.next.data + " "); // "归来"开始打印
        }
    }

    // 添加数据，
    public SingleNode<E> add(E data) {
        SingleNode<E> node = new SingleNode<E>(data);
        return add(node);
    }

    // 批量添加数据
    public void addBatch(List<E> list) {
        for (E e : list) {
            SingleNode<E> node = new SingleNode<E>(e);
            add(node);
        }
    }

    // 添加节点，并返回该节点
    public SingleNode<E> add(SingleNode<E> node) {
        SingleNode<E> cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
        size++;
        return node;
    }

    // 添加头节点
    public SingleNode<E> addHead(SingleNode<E> node) {
        SingleNode<E> cur = head;
        SingleNode<E> temp = head.next;
        cur.next = node;
        node.next = temp;
        head = node;
        return head;
    }

    // 指定位置插入节点，并返回该节点
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

    // 指定位置删除节点，并返回该节点数据
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

    // 获取索引位置的值
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
        SingleNode<E> cur = head;
        while (cur.next != null) { // 外循环
            SingleNode<E> temp = cur;
            while (temp != null && temp.next != null) { // 内循环
                if (cur.data.equals(temp.next.data)) {
                    // temp 是重复节点的上一个节点
                    SingleNode<E> node = temp.next;// 重复节点
                    temp.next = node.next;
                    node.next = null;
                    size--;
                }
                temp = temp.next;
            }
            cur = cur.next;
        }
    }

    /**
     * 判断链表中是否有环
     * 双指针：快慢指针
     */
    public boolean hasLoop() {
        SingleNode<E> slow = head.next; // 慢指针
        SingleNode<E> fast = head.next; // 快指针
        while (fast != null && fast.next != null
                && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断链表中是否有环，并返回进入环的节点
     *  有：返回进入环的节点
     *  无：返回null
     */
    public SingleNode<E> detectCycle(){
        SingleNode<E> slow = head.next; // 慢指针
        SingleNode<E> fast = head.next; // 快指针
        while (fast != null && fast.next != null
                && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
               break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    /**
     * 返回两链表的交点(若不相交，返回null)
     * @param list2 目标链表
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
     *  反转链表-迭代
     */
    public void reverseLinkedList01() {
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

    // 链表反转-递归
    public void reverseLinkedList02() {
        head.next = recursion(head.next);
    }

    // 链表反转-递归
    public SingleNode<E> recursion(SingleNode<E> node) {
        if (node == null || node.next == null) {
            return node;
        }
        SingleNode<E> new_node = recursion(node);
        node.next.next = node;
        node.next = null;
        return new_node;
    }

    /**
     * 删除链表重复元素
     * @param data
     * @return
     */
    public SingleNode<E> removeElements(E data) {
        SingleNode<E> cur = head;
        while (cur.next != null) {
            if (cur.next.data.equals(data)) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return cur;
    }

    /**
     * 奇偶链表
     * 获取奇数链表，偶数链表，拼接起来
     * @return
     */
    public SingleNode<E> oddEvenList() {
        SingleNode<E> cur = head;
        SingleNode<E> doub = head.next;
        SingleNode<E> one = cur;
        SingleNode<E> two = doub;

        while (cur != null && cur.next != null && cur.next.next != null) {
            cur.next = cur.next.next;
            cur = cur.next;
            doub.next = doub.next.next;
            doub = doub.next;
        }
        cur.next = two;
        return one;
    }

    /**
     * 回文联表
     *  以中间节点，两边是相同的
     * @return
     */
    public boolean isPalindrome() {
        SingleNode<E> slow = head.next;
        SingleNode<E> fast = head.next;
        if (slow == null) {
            return false;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //如果fast不为空，说明链表的长度是奇数个
        if (fast != null) {
            slow = slow.next;
        }

        SingleNode<E> first = head.next;
        SingleNode<E> pre = null;

        while (slow.next != null) {
            SingleNode<E> temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }
        slow.next = pre;

        while (slow != null) {
            if (first.data.equals(slow.data)) {
                first = first.next;
                slow = slow.next;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 合并两个链表
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * @param node1
     * @param node2
     * @return
     */
    public SingleNode<Integer> mergeTwoLists(SingleNode<Integer> node1, SingleNode<Integer> node2) {
        SingleNode<Integer> node = new SingleNode<Integer>(null);
        SingleNode<Integer> result = node;
        while (node1 != null && node2 != null) {
            if (node1.data > node2.data) {
                node.next = node2;
                node2 = node2.next;
            } else {
                node.next = node1;
                node1 = node1.next;
            }
            node = node.next;
        }

        if (node1 != null) {
            node.next = node1;
        } else if (node2 != null) {
            node.next = node2;
        }
        return result.next;
    }

    /**
     * 两个链表的数值相加
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode.cn/leetbook/read/linked-list/fv6w7/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param node1
     * @param node2
     * @return
     */
    public SingleNode<Integer> addTwoNumbers(SingleNode<Integer> node1, SingleNode<Integer> node2) {

        SingleNode<Integer> node = new SingleNode<Integer>(null);
        SingleNode<Integer> result = node;

        int carry = 0;
        while (node1 != null || node2 != null || carry > 0) {
            int num1 = node1 == null ? 0 : node1.data;
            int num2 = node2 == null ? 0 : node2.data;
            int sum = num1 + num2 + carry;
            carry = sum / 10;// 余数
            result.next = new SingleNode<Integer>(sum % 10);
            result = result.next;
            if (node1 != null) {
                node1 = node1.next;
            }
            if (node2 != null) {
                node2 = node2.next;
            }
        }
        return result.next;
    }


}
