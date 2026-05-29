class Solution {
    public int minElement(int[] nums) {
        int minSum = Integer.MAX_VALUE;    
        for (int num : nums) {
            int currentSum = 0;
            while (num > 0) {
                currentSum += num % 10;
                num /= 10;
            }
            minSum = Math.min(minSum, currentSum);
        }
        
        return minSum;
    }
}