class Solution {
    public double findMaxAverage(int[] nums, int k) {
       int windowStart=0;
       int windowEnd=0;
       int currSum=0;
       int maxSum=Integer.MIN_VALUE;
       while(windowEnd<nums.length){
        //Include WIndow
        currSum+=nums[windowEnd];
        if(windowEnd>=k-1){ //Check for size K
            maxSum=Math.max(currSum,maxSum);
            currSum-=nums[windowStart];
            windowStart++;
        }
        windowEnd++; //increment windowEnd
       }
       return (double) maxSum/k;
    }
}