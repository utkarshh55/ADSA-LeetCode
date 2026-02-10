class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q=new LinkedList();
        boolean[] visited=new boolean[rooms.size()];
        q.add(0);
        visited[0]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int i:rooms.get(curr)){
                if(!visited[i]){
                    visited[i]=true;
                    q.add(i);
                }
            }
        }
        for(boolean v:visited){
            if(!v){
                return false;
            }
        }
        return true;
    }
}