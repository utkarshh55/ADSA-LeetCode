// Copy Paste
class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);  // sentinel for easier comparisons

        for (int num : nums) {
            // pop elements bigger than current number
            while (!stack.isEmpty() && stack.peek() > num) {
                stack.pop();
            }
            // if stack top < current number → new increase → count one operation
            if (stack.isEmpty() || stack.peek() < num) {
                ans++;
                stack.push(num);
            }
            // if stack.peek() == num, do nothing (continuation)
        }

        return ans;
    }
}
