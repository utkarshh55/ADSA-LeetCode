class Solution {
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int max=Integer.MIN_VALUE;
            int levelSize=q.size();
            for(int i=0;i<levelSize;i++){
                TreeNode node=q.poll();
                max=Math.max(max,node.val);

                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            ans.add(max);
        }
        return ans;
    }
}