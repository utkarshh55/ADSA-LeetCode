class Solution {
    class Pair implements Comparable<Pair>{
        int row;
        int col;
        int time;
        Pair(int row,int col,int time){
            this.row=row;
            this.col=col;
            this.time=time;        }
        public int compareTo(Pair other){
            return Integer.compare(this.time,other.time);
        }
    }
    int n;
    int dx[]={0,0,-1,1};
    int dy[]={1,-1,0,0};
    public boolean isValid(int r,int c,int n){
        if(r>=0 && r<n && c>=0 && c<n) return true;
        return false;
    }
    public int swimInWater(int[][] grid) {
        n=grid.length;
        boolean isVisited[][]= new boolean[n][n];
        PriorityQueue<Pair> pq= new PriorityQueue<>();
        pq.add(new Pair(0,0,grid[0][0]));
        while(!pq.isEmpty()){
            Pair p= pq.poll();
            int currrow=p.row;
            int currcol=p.col;
            int currtime=p.time;
            if(currrow==n-1 && currcol==n-1) return currtime;
            for(int i=0;i<4;i++){
                int adjrow=currrow+dx[i];
                int adjcol=currcol+dy[i];
                if(isValid(adjrow,adjcol,n) && !isVisited[adjrow][adjcol]){
                    isVisited[adjrow][adjcol]=true;
                    int ntime=grid[adjrow][adjcol];
                    if(currtime<ntime){
                        pq.add(new Pair(adjrow,adjcol,ntime));
                    }
                    else{
                        pq.add(new Pair(adjrow,adjcol,currtime));
                    }
                }
            }
        }
        return 0;
    }
}