package com.wdc.list;

/**
 * Title: 链表的Java实现
 * Description: 链表结构包含两个要素： 头结点head + 链表大小size，操作包括：
 * 				链表的增删
 * 				链表是否为空
 * 				链表的大小
 * 				链表的打印输出
 * 				删除链表重复节点
 *  			链表倒数第K个元素
 *  			链表的反转
 *  			链表的倒序输出
 *  			链表的中间节点
 *  			链表是否有环
 *  			链表节点的删除(不知道头结点的情况下)
 *  			链表是否相交
 *  			链表的交点
 *
 * @author wendongchao
 * @ClassName LinkedList
 * @Date 2022/2/23 10:19
 */
public class LinkedList<E> {
    private SingleNode<E> head; // 链表表头
    private int size; // 链表大小

    /**
     * 初始化头节点
     */
    public LinkedList() {
        head = new SingleNode<E>(null);
    }

    public SingleNode<E> getHead() {
        return head;
    }

    public int size(){
        return size;
    }

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
     * 添加数据到链表队尾
     * @param node
     * @return
     */
    public SingleNode<E> addEnd(SingleNode<E> node) {
        SingleNode<E> cur = head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
        size++;
        return node;
    }

    public SingleNode<E> addEnd(E data) {
        SingleNode<E> node = new SingleNode<E>(data);// 插入的节点
        return addEnd(node);
    }

    /**
     * 指定位置插入节点，并返回新节点
     * @param data
     * @param index
     * @return
     * @throws Exception
     */
    public SingleNode<E> addIndex(E data, int index) throws Exception {
        SingleNode<E> node = new SingleNode<E>(data);// 插入的节点
        return addIndex(node,index);
    }

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
     * 指定位置删除链表中元素
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
     * 删除链表末尾元素
     * @return
     * @throws Exception
     */
    public E remove() throws Exception {
        return remove(size - 1);
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
     * 找出单链表中倒数第K个元素
     * 时间复杂度：O(n)
     * @param k
     * @return
     * @throws Exception
     */
    public SingleNode<E> getEndK(int k) throws Exception {
        if (k > size - 1 || k < 0) {
            throw new Exception("超出范围...");
        }
        SingleNode<E> cur = head.next;
        if (cur == null) {
            return null;
        }
        for (int i = 0; i < size - k; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * @description 反转链表
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

    /**
     * @description 寻找单链表中的中间节点(双指针法)
     * @author rico
     */
    public void printMiddleSingleNodes() {
        SingleNode<E> index1 = head.next; // 慢指针
        SingleNode<E> index2 = head.next; // 快指针
        if (head.next == null) {
            System.out.println(index1.data);
        }
        while (index2 != null && index2.next != null
                && index2.next.next != null) {
            index1 = index1.next;
            index2 = index2.next.next;
        }
        System.out.print(index1.data); // 第一个中间节点
        if (index2.next != null) { // 当链表长度为偶数时，打印第二个中间节点
            System.out.println(index1.next.data);
        }
    }

    /**
     * @description 判断单链表是否有环(双指针法)
     * @author rico
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
     * @description 在不知道头结点的前提下，删除指定节点
     * @author rico
     * @param node
     * @return
     */
    public boolean deleteSingleNodeWithoutHead(SingleNode<E> node) {
        if (node == null || node.next == null) { // 当指定节点为空或者为尾节点时，无法删除
            return false;
        }

        SingleNode<E> next = node.next;

        // 将后继节点的内容复制到当前节点
        node.data = next.data;
        node.next = next.next;

        // 将后继节点清空
        next.next = null;
        next.data = null;
        return true;
    }

    /**
     * @description 判断当前链表与目标链表是否相交(相交与否取决于尾节点是否相同)
     * @return
     */
    public boolean isIntersect(LinkedList<E> list2) {
        SingleNode<E> cur1 = head.next;   // 当前链表
        SingleNode<E> cur2 = list2.getHead().next;  // 目标链表

        // 两链表有一个为空，则返回 false
        if(cur1 == null || cur2 == null){
            return false;
        }

        // 遍历到第一个链表的尾节点
        while(cur1.next != null){
            cur1 = cur1.next;
        }

        // 遍历到第二个链表的尾节点
        while(cur2.next != null){
            cur2 = cur2.next;
        }

        return cur1 == cur2;  // 相交与否取决于尾节点是否相同
    }

    /**
     * @description 返回两链表的交点(若不相交，返回null)
     * @author rico
     * @return
     */
    public SingleNode<E> getIntersectionPoint(LinkedList<E> list2) {
        SingleNode<E> cur1 = head.next;   // 当前链表
        SingleNode<E> cur2 = list2.getHead().next;  // 目标链表

        if(this.isIntersect(list2)){  // 先判断是否相交
            // 让长度较长的链表先移动step步
            int step = Math.abs(list2.size - this.size);
            if(list2.size > this.size){
                while(step > 0){
                    cur2 = cur2.next;
                    step --;
                }
            }else if(list2.size < this.size){
                while(step > 0){
                    cur1 = cur1.next;
                    step --;
                }
            }

            //两个指针同时移动，一旦指向同一个节点，即为交点
            while(cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }
        return null;
    }
}
