/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy=new TreeNode(0);
        curr=dummy;
        inorder(root);
        return dummy.right;
    }
    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        root.left=null;
        curr.right=root;
        curr=curr.right;
        inorder(root.right);
    }
}