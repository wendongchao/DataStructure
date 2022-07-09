package com.wdc.structure.list.list2;



/**
 * 单链表：头节点有数据
 * @author dongchao
 * @time 2022-07-09 10:35
 */
public class LinkedList {
    private SingleNode head; // 链表表头
    private int size; // 链表大小

    // 初始化头节点
    public LinkedList() {
        size = 0;
        head = new SingleNode(0);
    }

    // 获取头节点
    public SingleNode getHead() {
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
        SingleNode cur = head;
        while (cur.next != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    // 从尾到头输出单链表(递归法)
    public void reversePrint(SingleNode head) {
        if (head.next != null) {
            reversePrint(head.next); // 不断"递去"
            System.out.print(head.next.data + " "); // "归来"开始打印
        }
    }

    // 获取链表中第index个位置的值，如果索引无效，返回-1
    public int getIndex(int index) {
        if (index < 0 || index > size) {
            return -1;
        }
        SingleNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.data;
    }

    // 在链表的第一个元素之前添加一个值为data的新节点，插入后，新节点成员链表首节点
    public void addAtHead(int data) {
        SingleNode node = new SingleNode(data);
        if (isEmpty()) {// 如果是空链表，那么第一个节点就是该节点
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    // 链表尾部追加节点
    public void addAtTail(int data) {
        SingleNode node = new SingleNode(data);
        if (isEmpty()) {
            addAtHead(data);
            return;
        }

        SingleNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
        size++;
    }

    /**
     * 在链表中的第index个节点之前添加值为 data 的节点。
     * 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
     * 如果 index 大于链表长度，则不会插入节点。
     * 如果 index 小于0，则在头部插入节点。
     * @param index
     * @param data
     */
    public void addAtIndex(int index, int data) {
        if (index < 0) {
            addAtHead(data);
            return;
        }
        if (index == size) {
            addAtTail(data);
        }
        if (index > size) {
            return;
        }

        SingleNode node = new SingleNode(data);
        SingleNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        SingleNode temp = cur.next;
        cur.next = node;
        node.next = temp;
        size++;
    }

    // 如果索引 index 有效，则删除链表中的第 index 个节点。
    public void deleteAtIndex(int index) {
        if (index < 0 || index > size) {
            System.out.println("索引无效");
            return;
        }
        if (isEmpty()) {
            return;
        }

        if (index == 0 ) {
            if (size == 1) {
                SingleNode node = new SingleNode(null);
                head = node;
                size--;
                return;
            } else {
                SingleNode temp = head.next;
                head = temp;
                size--;
                return;
            }
        }

        SingleNode cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        // cur 是index的前一个节点
        SingleNode temp = cur.next;
        cur.next = temp.next;
        size--;
    }

    /**
     * 删除链表中的重复元素(外循环 + 内循环)
     * 时间复杂度：O(n^2)
     */
    public void removeDuplicateNode() {
        SingleNode cur = head;
        while (cur.next != null) { // 外循环
            SingleNode temp = cur;
            while (temp != null && temp.next != null) { // 内循环
                if (cur.data.equals(temp.next.data)) {
                    // temp 是重复节点的上一个节点
                    SingleNode node = temp.next;// 重复节点
                    temp = node.next;
                    size--;
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
     */
    public SingleNode getEndK(int k) {
        if (k > size || k < 0) {
            System.out.println("索引越界");
            return null;
        }
        if (isEmpty()) {
            return null;
        }
        SingleNode cur = head;
        for (int i = 0; i < size - k; i++) {
            cur = cur.next;
        }
        return cur;
    }


}
