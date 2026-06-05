class Solution {
    int ans = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root);
        return ans;
    }
    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{-1, -1};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int leftLen = left[1] + 1;
        int rightLen = right[0] + 1;
        ans = Math.max(ans, Math.max(leftLen, rightLen));
        return new int[]{leftLen, rightLen};
    }
}