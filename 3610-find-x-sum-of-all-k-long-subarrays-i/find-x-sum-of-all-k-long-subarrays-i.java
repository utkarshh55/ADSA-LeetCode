//Copy Paste
class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int[] freq = new int[51]; // because nums[i] <= 50

        // Initialize first window
        for (int i = 0; i < k; i++) {
            freq[nums[i]]++;
        }

        for (int i = 0; i <= n - k; i++) {
            // Calculate x-sum for current window
            ans[i] = getXSum(freq, x);

            // Slide window → remove leftmost element and add next
            if (i + k < n) {
                freq[nums[i]]--;     // remove outgoing element
                freq[nums[i + k]]++; // add incoming element
            }
        }

        return ans;
    }

    private int getXSum(int[] freq, int x) {
        // Make a temporary list of [value, freq]
        List<int[]> list = new ArrayList<>();
        for (int val = 1; val <= 50; val++) {
            if (freq[val] > 0) {
                list.add(new int[]{val, freq[val]});
            }
        }

        // Sort by frequency descending, then value descending
        Collections.sort(list, (a, b) -> {
            if (b[1] == a[1]) return b[0] - a[0];
            return b[1] - a[1];
        });

        int sum = 0;
        int count = 0;
        for (int[] pair : list) {
            sum += pair[0] * pair[1];
            count++;
            if (count == x) break;
        }
        return sum;
    }
}
