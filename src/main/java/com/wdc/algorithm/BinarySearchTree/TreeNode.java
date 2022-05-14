package com.wdc.algorithm.BinarySearchTree;

/**
 * @author wendongchao
 * @ClassName TreeNode
 * @Date 2022/2/23 10:27
 */
public class TreeNode {

    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data){
        this.data = data;
    }

    @Override
    public String toString() {
        return "TreeNode [data=" + data + "]";
    }

}
