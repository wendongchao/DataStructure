package com.wdc.tree;

/**
 * @auther wendongchao
 * @date 2024/2/21 17:20
 **/
public class Node {
    int value;
    Node left;
    Node right;
    Node next;
    public Node(int value) {
        this.value = value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
