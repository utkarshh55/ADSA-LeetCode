class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                // dono direction try karo
                if (check(nums.clone(), i, -1)) count++;
                if (check(nums.clone(), i, 1)) count++;
            }
        }
        return count;
    }
    private boolean check(int[] nums, int curr, int dir) {
        int n = nums.length;
        while (curr >= 0 && curr < n) {
            if (nums[curr] == 0) {
                curr += dir;
            } else {
                nums[curr]--;
                dir = -dir; // reverse direction
                curr += dir;
            }
        }
        // check if sab 0 ho gaye
        for (int num : nums) {
            if (num != 0) return false;
        }
        return true;
    }
}
