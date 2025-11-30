class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalSum=0;
        for(int num:nums){
            totalSum+=num;
        }
        int rem=(int)(totalSum%p);
        if(rem==0) return 0;
        Map<Integer,Integer> mp=new HashMap<>();
        mp.put(0,-1);
        long prefix=0;
        int result=nums.length;
        for(int i=0;i<nums.length;i++){
            prefix=(prefix+nums[i])%p;
            int need=(int)((prefix-rem+p)%p);
            if(mp.containsKey(need)){
                result=Math.min(result,i-mp.get(need));
            }
            mp.put((int)prefix,i);
        }
        return result==nums.length?-1:result;
    }
}