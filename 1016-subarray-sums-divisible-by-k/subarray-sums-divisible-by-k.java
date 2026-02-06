class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(0,1);
        int windowStart=0;
        int windowEnd=0;
        int count=0;
        int sum=0;
        while(windowEnd<nums.length){
            sum+=nums[windowEnd];
            int rem=sum%k;
            if(rem<0) rem+=k;
            count+=mp.getOrDefault(rem,0);
            mp.put(rem,mp.getOrDefault(rem,0)+1);
            windowEnd++;
        }
        return count;
    }
}