class Solution {
    public boolean isPossible(int[] nums, int k, int largestSum) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] <= largestSum) {
                sum += nums[i];
            } else {
                count++;
                sum = nums[i];
                if (count > k) {
                    return false;
                }
            }
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int low = 0;
        int high = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(nums, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}