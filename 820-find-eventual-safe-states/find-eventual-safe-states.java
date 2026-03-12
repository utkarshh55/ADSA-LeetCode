class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> rev = new ArrayList<>();
        for(int i=0;i<n;i++) rev.add(new ArrayList<>());
        int[] outdegree = new int[n];
        for(int i=0;i<n;i++){
            outdegree[i] = graph[i].length;
            for(int v : graph[i]){
                rev.get(v).add(i);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(outdegree[i] == 0) q.add(i);
        }
        boolean[] safe = new boolean[n];
        while(!q.isEmpty()){
            int node = q.poll();
            safe[node] = true;
            for(int parent : rev.get(node)){
                outdegree[parent]--;
                if(outdegree[parent] == 0){
                    q.add(parent);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(safe[i]) ans.add(i);
        }
        return ans;
    }
}