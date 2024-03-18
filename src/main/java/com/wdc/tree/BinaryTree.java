package com.wdc.tree;

import java.util.*;

/**
 * @auther wendongchao
 * @date 2024/2/21 17:22
 **/
public class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        super();
    }

    public void arrayToTree(Integer[] arr) {
        root = arrayToTree(arr, 0);
    }

    // 数组转树
    public TreeNode arrayToTree(Integer[] arr, int index) {
        if (index >= arr.length || arr[index] == null) {
            return null;
        }
        TreeNode treeNode = new TreeNode(arr[index]);
        treeNode.left = arrayToTree(arr, 2 * index + 1);
        treeNode.right = arrayToTree(arr, 2 * index + 2);
        int leftDepth = treeNode.left == null ? 0 : treeNode.left.depth;
        int rightDepth = treeNode.right == null ? 0 : treeNode.right.depth;
        treeNode.depth = Math.max(leftDepth, rightDepth) + 1;
        return treeNode;
    }

    public Integer[] treeToArray() {
        int arraySize = (int) (Math.pow(2, root.depth) - 1);
        Integer[] result = new Integer[arraySize];
        treeToArray(result, root, 0);
        return result;
    }

    // 树转数组
    public void treeToArray(Integer[] arr, TreeNode root, int index) {
        if (root == null) {
            return;
        }
        arr[index] = root.val;
        treeToArray(arr, root.left, 2 * index + 1);
        treeToArray(arr, root.right, 2 * index + 2);
    }

    // 前序遍历-树转列表（使用层序遍历的方式）
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            // 注意：栈是先进后出，所以先添加右节点
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
            list.add(pop.val);
        }
        return list;
    }

    // 中序遍历-树转列表（使用层序遍历的方式）
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;
        TreeNode cur = new TreeNode(-1);
        cur = root;
        while (!stack.isEmpty()|| cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode pop = stack.pop();
            list.add(pop.val);
            cur = pop.right;
        }
        return list;
    }

    // 后序遍历-树转列表（使用层序遍历的方式）
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        // 记录上一个访问节点
        TreeNode preNode = null;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 出栈
            cur = stack.pop();
            // 当前节点没有右子树或者右子树已经访问过
            if (cur.right == null || cur.right == preNode) {
                list.add(cur.val);
                preNode = cur;
                cur = null;
            } else {
                stack.push(cur);
                cur = cur.right;
            }
        }
        return list;
    }

    // 前序遍历
    public void preOrder(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return;
        }
        arr.add(node.val);
        preOrder(node.left, arr);
        preOrder(node.right, arr);
    }

    // 中序遍历
    public void inOrder(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return;
        }
        inOrder(node.left, arr);
        arr.add(node.val);
        inOrder(node.right, arr);
    }

    // 后序遍历
    public void postOrder(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return;
        }
        postOrder(node.left, arr);
        postOrder(node.right, arr);
        arr.add(node.val);
    }

    // 层序遍历
    public List<List<Integer>> levelOrder(TreeNode node) {
        List<List<Integer>> result = new LinkedList<>();
        if (node == null) {
            return result;
        }
        //入队 root 节点，也就是第一层
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                //孩子节点不为空，则入队
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
                level.add(poll.val);
            }
            result.add(0,level);
        }
        return result;
    }

    // leetcode 103 二叉树的锯齿形层序遍历
    public List<List<Integer>> zigzagLevelOrder(TreeNode node) {
        List<List<Integer>> result = new LinkedList<>();
        if (node == null) {
            return result;
        }
        boolean isOrderLeft = true;
        //入队 root 节点，也就是第一层
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                //孩子节点不为空，则入队
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
                if (isOrderLeft){
                    level.add(poll.val);
                } else {
                    level.add(0,poll.val);
                }
            }
            result.add(level);
            isOrderLeft = !isOrderLeft;
        }
        return result;
    }

    // leetcode 199 二叉树的右视图 BFS
    public List<Integer> rightSideView(TreeNode node) {
        List<Integer> result = new LinkedList<>();
        if (node == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
                if (i == size - 1){
                    result.add(poll.val);
                }
            }
        }
        return result;
    }

    // leetcode 515 在每个树行中找最大值 BFS
    public List<Integer> largestValues(TreeNode node) {
        List<Integer> result = new LinkedList<>();
        if (node == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            Queue<Integer> temp = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
                if (temp.isEmpty()) {
                    temp.offer(poll.val);
                } else if (temp.peek() < poll.val) {
                    temp.clear();
                    temp.offer(poll.val);
                }
            }
            result.add(temp.peek());
        }
        return result;
    }

    // leetcode 637 二叉树的层平均值
    public List<Double> averageOfLevels(TreeNode node) {
        List<Double> averages = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                sum += poll.val;
                TreeNode left = poll.left, right = poll.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            averages.add(sum / size);
        }
        return averages;
    }

    // leetcode 116 填充每个节点的下一个右侧节点指针
    public Node connect(Node node) {
        if(node==null) {
            return node;
        }
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(node);
        while(queue.size()>0) {
            int size = queue.size();
            //将队列中的元素串联起来
            Node tmp = queue.get(0);
            for(int i=1;i<size;++i) {
                tmp.next = queue.get(i);
                tmp = queue.get(i);
            }
            //遍历队列中的每个元素，将每个元素的左右节点也放入队列中
            for(int i=0;i<size;++i) {
                tmp = queue.remove();
                if(tmp.left!=null) {
                    queue.add(tmp.left);
                }
                if(tmp.right!=null) {
                    queue.add(tmp.right);
                }
            }
        }
        return node;
    }

    // leetcode 117 填充每个节点的下一个右侧节点指针2
    public Node connect2(Node node) {
        if (node == null)
            return node;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            //每一层的数量
            int levelCount = queue.size();
            //前一个节点
            Node pre = null;
            for (int i = 0; i < levelCount; i++) {
                //出队
                Node poll = queue.poll();
                //如果pre为空就表示node节点是这一行的第一个，
                //没有前一个节点指向他，否则就让前一个节点指向他
                if (pre != null) {
                    pre.next = poll;
                }
                //然后再让当前节点成为前一个节点
                pre = poll;
                //左右子节点如果不为空就入队
                if (poll.left != null)
                    queue.add(poll.left);
                if (poll.right != null)
                    queue.add(poll.right);
            }
        }
        return node;
    }

}
