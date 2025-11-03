class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalTime=0;
        int prev=0;
        for(int i=1;i<colors.length();i++){
            if(colors.charAt(i)==colors.charAt(prev)){
                if(neededTime[i]<neededTime[prev]){
                    totalTime+=neededTime[i];
                }else{
                    totalTime+=neededTime[prev];
                    prev=i;
                }
            }else{
                prev=i;
            }
        }
        return totalTime;
    }
}