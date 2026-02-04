class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum=0;
        int maxSum=nums[0];
        int currMax=0;
        int minSum=nums[0];
        int currMin=0;
        for(int n:nums){
            currMax=Math.max(currMax+n,n);
            maxSum=Math.max(currMax,maxSum);

            currMin=Math.min(currMin+n,n);
            minSum=Math.min(currMin,minSum);
            totalSum+=n;
        }
        if(maxSum<0) return maxSum;
        return Math.max(maxSum,totalSum-minSum);
    }
}