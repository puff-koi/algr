package com.company.tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BFS {

    //todo 102. 二叉树的层序遍历
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int num = deque.size();
            for(int i = 0;i<num;i++){
                TreeNode now = deque.poll();
                list.add(now.val);
                if(now.left!=null){deque.offer(now.left);}
                if(now.right!=null){deque.offer(now.right);}
            }
            ans.add(list);
        }

        return ans;
    }

    public void bfs(TreeNode treeNode){
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offer(treeNode);
        while(!stack.isEmpty()){
            TreeNode treeNode1 = stack.poll();
            if (treeNode1.left!=null){
                stack.offer(treeNode1.left);
            }
            if (treeNode1.right!=null){
                stack.offer(treeNode1.right);
            }
        }
    }



    //todo 429. N 叉树的层序遍历
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Deque<Node> stack = new LinkedList<>();
        stack.offer(root);
        while(!stack.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int n = stack.size();
            for(int i=0;i<n;i++){
                Node in = stack.poll();
                list.add(in.val);
                int inNum = in.children.size();
                if(inNum!=0){
                    for(Node inNode: in.children){
                        stack.offer(inNode);
                    }
                }
            }
            ans.add(list);
        }
        return ans;
    }


}
