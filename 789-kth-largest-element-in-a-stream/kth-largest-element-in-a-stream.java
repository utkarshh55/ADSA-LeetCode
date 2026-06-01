class KthLargest {
    PriorityQueue<Integer> pq= pq = new PriorityQueue<>();;
    int n;
    public KthLargest(int k, int[] nums) {
        n= k;
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
    }
    public int add(int val) {
        pq.offer(val);
        if (pq.size() > n) {
            pq.poll();
        }
        return pq.peek();
    }
}