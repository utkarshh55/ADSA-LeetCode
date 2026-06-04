class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n=deck.length;
        Arrays.sort(deck);
        int [] ans=new int[n];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            q.add(i);
        }
        for(int card:deck){
            ans[q.poll()]=card;
            if(!q.isEmpty()){
                q.add(q.poll());
            }
        }
        return ans;
    }
}