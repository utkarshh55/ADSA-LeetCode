class Solution {
    public int countPartitions(int[] nums) {
        int n=nums.length;
        long total=0;
        for(int x:nums) total+=x;
        int totalParity=(int)(total%2);
        long prefix=0;
        int count=0;
        for(int i=0;i<n-1;i++){
            prefix+=nums[i];
            int leftParity=(int)(prefix%2);
            int rightParity=(totalParity-leftParity+2)%2;
            if(leftParity==rightParity){
                count++;
            }
        }
        return count;
    }
}