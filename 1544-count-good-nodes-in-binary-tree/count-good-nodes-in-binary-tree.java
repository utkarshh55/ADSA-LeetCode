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
    int count=1;
    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        int max_value=root.val;
        helper(root.left,max_value);
        helper(root.right,max_value);
        return count;

    }
    public void helper(TreeNode root,int max_value){
        if(root==null) return;
        if(root.val>=max_value){
            count++;
            max_value=root.val;
        }
        helper(root.left,max_value);
        helper(root.right,max_value);
    }
}