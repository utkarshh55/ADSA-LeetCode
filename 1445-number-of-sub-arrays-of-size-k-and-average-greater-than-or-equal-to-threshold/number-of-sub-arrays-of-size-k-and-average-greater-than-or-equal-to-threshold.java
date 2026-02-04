class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int windowStart=0;
        int windowEnd=0;
        int currSum=0;
        int count=0;
        int target=threshold*k;
        while(windowEnd<arr.length){
            currSum+=arr[windowEnd];
            if(windowEnd>=k-1){
                if(currSum>=target){
                    count++;
                }
                currSum-=arr[windowStart];
                windowStart++;
            }
            windowEnd++;
        }
        return count;
    }
}