class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for (char ch : s.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> pq =new PriorityQueue<>((a, b)->mp.get(b)-mp.get(a));
        pq.addAll(mp.keySet());
        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            char ch = pq.poll();
            int freq = mp.get(ch);
            while (freq-- > 0) {
                ans.append(ch);
            }
        }
        return ans.toString();
    }
}