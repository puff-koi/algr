package com.company.tree;

import java.util.List;

public class DFS {


    //todo 剑指 Offer 68 - II. 二叉树的最近公共祖先
    private TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        boolean isAllNotNull = lson && rson; boolean isOneNull = lson || rson;
        boolean oneIsEqualsRoot = root.val == p.val || root.val == q.val;
        if (isAllNotNull || ( oneIsEqualsRoot && isOneNull)) {
            ans = root;
        }
        return isOneNull || oneIsEqualsRoot;
    }
    //简化版
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root.val == p.val || root.val == q.val) return root;
        TreeNode l = lowestCommonAncestor(root.left,p,q);
        TreeNode r = lowestCommonAncestor(root.right,p,q);

        return l==null ? r : (r==null? l:root);
    }


    //todo 559. N 叉树的最大深度
    public int maxDepth(Node root) {
        return dfs(root);
    }

    public int dfs(Node root){
        if(root==null) return 0;
        int max = 0;
        if(root.children.size()>0){
            List<Node> list = root.children;
            for(Node node: list){
                max = Math.max(dfs(node),max);
            }
        }
        return max + 1;
    }
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

    //todo 111. 二叉树的最小深度
    public int minDepth(TreeNode1 root) {
        return dfsmin(root);
    }

    public int dfsmin(TreeNode1 root){
        if(root==null){return 0;}
        if(root.left==null && root.right ==null) return 1;

        int min = Integer.MAX_VALUE;
        if(root.left!=null){
            min = Math.min(dfsmin(root.left),min);
        }

        if(root.right!=null){
            min = Math.min(dfsmin(root.right),min);
        }

        return min + 1;
    }

 public class TreeNode1 {
      int val;
      TreeNode1 left;
      TreeNode1 right;
      TreeNode1() {}
      TreeNode1(int val) { this.val = val; }
      TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    //todo 剑指 Offer 55 - I. 二叉树的深度
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    int dfs(TreeNode root) {
        if (root == null) {return 0;}
        return Math.max(dfs(root.left),dfs(root.right)) + 1;

    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
