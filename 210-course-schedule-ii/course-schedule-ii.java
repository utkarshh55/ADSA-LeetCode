class Solution {
    public int[] findOrder(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        int indegree[]= new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int arr[]:edges){
            int a=arr[0];
            int b=arr[1];
            adj.get(b).add(a);
            indegree[a]+=1;
        }
        Queue<Integer> q= new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int x=q.poll();
            ans.add(x);
            for(int y:adj.get(x)){
                indegree[y]-=1;
                if(indegree[y]==0) q.add(y);
            }
        }
        if(ans.size()==n){
            int arr[]= new int[n];
            for(int i=0;i<ans.size();i++){
                arr[i]=ans.get(i);
            }
            return  arr;
        }
        else{
            return new int[0];
        }
    }
}