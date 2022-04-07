package com.company.tree;

public class invertTree {

    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
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
        //todo 951. 翻转等价二叉树
     public boolean flipEquiv(TreeNode root1, TreeNode root2) {
         if (root1 == root2)
             return true;
         if (root1 == null || root2 == null || root1.val != root2.val)
             return false;

         return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                 flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
     }
}
