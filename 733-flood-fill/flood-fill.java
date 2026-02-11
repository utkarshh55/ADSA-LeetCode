class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    public boolean isValid(int x, int y, int n, int m){
        if(x>=0 && x<n && y>=0 && y<m) return true;
        return false;
    }
    int rowDirection[] = {1,-1,0,0};
    int colDirection[] = {0,0,1,-1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        Queue<Pair> q= new LinkedList<>();
        int n = image.length;
        int m = image[0].length;
        boolean isVisited[][] = new boolean[n][m];
        q.add(new Pair(sr,sc));
        isVisited[sr][sc] = true;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int currRow = curr.row;
            int currCol = curr.col;
            image[currRow][currCol] = color;
            for(int i=0;i<4;i++){
                int newRow = currRow + rowDirection[i];
                int newCol = currCol + colDirection[i];
                if(isValid(newRow,newCol,n,m) && image[newRow][newCol]==oldColor && isVisited[newRow][newCol]==false){
                    isVisited[newRow][newCol] = true;
                    q.add(new Pair(newRow,newCol));
                }
            }


        }
        return image;    
    }
}