package com.wdc.tree;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BinaryTreeTest extends TestCase {

    public void testArrayToTree() {
        Integer[] arr = {1, 4, 2, 7, 5, 12, 9, 11, 10};
        BinaryTree  binaryTree = new BinaryTree();
        binaryTree.arrayToTree(arr);
    }

    public void testTreeToArray() {
        Integer[] arr = {1, 4, 2, 7, 5, 12, 9, 11, 10};
        BinaryTree  binaryTree = new BinaryTree();
        binaryTree.arrayToTree(arr);
        Integer[] result = binaryTree.treeToArray();
        System.out.println(Arrays.toString(result));
    }

    // 前序遍历
    public void testPreOrder() {
        Integer[] arr = {1, 4, 2, 7, 5, 12, 9, 11, 10};
        BinaryTree  binaryTree = new BinaryTree();
        binaryTree.arrayToTree(arr);
        List<Integer> integers = new ArrayList<>();
        binaryTree.preOrder(binaryTree.root,integers);
        integers.forEach(System.out::println);
    }

    // 中序遍历
    public void testInOrder() {
        Integer[] arr = {1, 4, 2, 7, 5, 12, 9, 11, 10};
        BinaryTree  binaryTree = new BinaryTree();
        binaryTree.arrayToTree(arr);
        List<Integer> integers = new ArrayList<>();
        binaryTree.inOrder(binaryTree.root,integers);
        integers.forEach(System.out::println);
    }

    // 后序遍历
    public void testPostOrder() {
        Integer[] arr = {1, 4, 2, 7, 5, 12, 9, 11, 10};
        BinaryTree  binaryTree = new BinaryTree();
        binaryTree.arrayToTree(arr);
        List<Integer> integers = new ArrayList<>();
        binaryTree.postOrder(binaryTree.root,integers);
        integers.forEach(System.out::println);
    }

    // 层序遍历
    public void testLevelOrder() {
        Integer[] arr = {1, 4, 2, 7, 5, 12, 9, 11, 10};
        BinaryTree  binaryTree = new BinaryTree();
        binaryTree.arrayToTree(arr);
        List<List<Integer>> lists = binaryTree.levelOrder(binaryTree.root);
        lists.forEach(System.out::println);
    }





}