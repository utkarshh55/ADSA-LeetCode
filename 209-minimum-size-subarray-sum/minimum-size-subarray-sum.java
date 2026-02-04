class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0;
        int minLen=Integer.MAX_VALUE;
        int windowStart=0;
        int windowEnd=0;
        while(windowEnd<nums.length){
            sum+=nums[windowEnd];
            while(sum>=target){
                minLen=Math.min(minLen,windowEnd-windowStart+1);
                sum-=nums[windowStart];
                windowStart++;
            }
            windowEnd++;
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
}