package com.wdc.leetcode;

/**
 * 两数之和：
 * 链接：https://leetcode.cn/problems/add-two-numbers/
 *
 * @auther: dongchao
 * @data: 2023/2/10 14:24
 */
public class AddTwoNumbers {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        void setVal(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int s1 = l1 != null ? l1.val : 0;
            int s2 = l2 != null ? l2.val : 0;
            int sum = s1 + s2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
