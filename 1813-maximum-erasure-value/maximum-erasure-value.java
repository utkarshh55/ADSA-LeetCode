class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int windowStart=0;
        int currSum=0;
        int maxSum=0;
        for(int windowEnd=0;windowEnd<nums.length;windowEnd++){
            while(set.contains(nums[windowEnd])){
                set.remove(nums[windowStart]);
                currSum-=nums[windowStart];
                windowStart++;
            }
            set.add(nums[windowEnd]);
            currSum+=nums[windowEnd];
            maxSum=Math.max(maxSum,currSum);
        }
        return maxSum;
    }
}