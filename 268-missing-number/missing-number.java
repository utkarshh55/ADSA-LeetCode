class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int expectedSum=n*(n+1)/2;
        int acctualSum=0;
        for(int num:nums){
            acctualSum+=num;
        }
        return expectedSum-acctualSum;
    }
}