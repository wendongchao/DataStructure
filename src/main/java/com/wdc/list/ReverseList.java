package com.wdc.list;

/**
 * 反转链表
 * @auther: dongchao
 * @data: 2022/11/22 08:47
 */
public class ReverseList {
    static class ListNode {
        int val;
        ListNode next;

        public  ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 迭代
    public static ListNode iterate(ListNode head) {
        ListNode prev = null,next;
        ListNode curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // 递归
    public static ListNode recursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode new_node = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return new_node;
    }


    public static void main(String[] args) {
        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        ListNode iterate = iterate(node1);
        System.out.println(iterate);
        ListNode recursion = recursion(node1);
        System.out.println(recursion);

    }
}
