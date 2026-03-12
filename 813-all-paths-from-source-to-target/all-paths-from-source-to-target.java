class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> start = new ArrayList<>();
        start.add(0);
        q.add(start);
        while(!q.isEmpty()){
            List<Integer> path = q.poll();
            int last = path.get(path.size()-1);
            if(last == graph.length-1){
                ans.add(path);
                continue;
            }
            for(int neigh : graph[last]){
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(neigh);
                q.add(newPath);
            }
        }
        return ans;
    }
}