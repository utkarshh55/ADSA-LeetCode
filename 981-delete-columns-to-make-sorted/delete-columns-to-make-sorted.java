class Solution {
    public int minDeletionSize(String[] strs) {
        int count=0;
        int rows=strs.length;
        int colms=strs[0].length();
        for(int c=0;c<colms;c++){
            for(int r=0;r<rows-1;r++){
                if(strs[r].charAt(c)>strs[r+1].charAt(c)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}