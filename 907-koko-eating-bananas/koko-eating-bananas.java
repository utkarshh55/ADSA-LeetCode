class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        Arrays.sort(piles);
        int low=1;
        int high=piles[n-1];
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            long hours=0;
            for(int i=0;i<piles.length;i++){
                hours+=(piles[i]+mid-1)/mid;
            }
            if(hours<=h){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}