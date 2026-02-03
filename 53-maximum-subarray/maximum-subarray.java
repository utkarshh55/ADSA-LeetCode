class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int MaxSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            MaxSum=Math.max(sum,MaxSum);
            if(sum<0){
            sum=0;
        }
        }
        return MaxSum;
    }
}