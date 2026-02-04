class Solution {
    public int longestOnes(int[] nums, int k) {
        int windowStart=0;
        int windowEnd=0;
        int zeroCount=0;
        int maxLen=0;
        while(windowEnd<nums.length){
            if(nums[windowEnd]==0){
                zeroCount++;
            }
            while(zeroCount>k){
                if(nums[windowStart]==0){
                   zeroCount--;
                }
                windowStart++;
            }
            maxLen=Math.max(maxLen,windowEnd-windowStart+1);
            windowEnd++;
        }
        return maxLen;
    }
}