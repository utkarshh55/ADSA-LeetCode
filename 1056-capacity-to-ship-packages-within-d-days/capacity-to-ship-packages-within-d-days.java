class Solution {
    public boolean isPossible(int[] weights, int days, int capacity){
        int count_days = 1;
        int curr_load = 0;
        for(int w : weights){
            if(curr_load + w > capacity){
                count_days++;
                curr_load = w;
            } else {
                curr_load += w;
            }
        }
        return count_days <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for(int w : weights){
            low = Math.max(low, w);   
            high += w;               
        }
        int ans = high;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isPossible(weights, days, mid)){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}