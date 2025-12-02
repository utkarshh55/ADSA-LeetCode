class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) freq[d]++;

        List<Integer> list = new ArrayList<>();

        // Generate all 3-digit even numbers
        for (int num = 100; num <= 998; num += 2) {
            int a = num / 100;        // hundreds
            int b = (num / 10) % 10;  // tens
            int c = num % 10;         // units (even)

            int[] need = new int[10];
            need[a]++; need[b]++; need[c]++;

            boolean ok = true;
            for (int i = 0; i < 10; i++) {
                if (need[i] > freq[i]) {
                    ok = false;
                    break;
                }
            }

            if (ok) list.add(num);
        }

        // Convert list to array
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) ans[i] = list.get(i);

        return ans;
    }
}
