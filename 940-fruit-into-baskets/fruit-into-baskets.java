class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        int windowStart=0;
        int windowEnd=0;
        int maxLen=Integer.MIN_VALUE;
        while(windowEnd<fruits.length){
            int fruit=fruits[windowEnd];
            mp.put(fruit,mp.getOrDefault(fruit,0)+1);
            while(mp.size()>2){
                int leftFruit=fruits[windowStart];
                mp.put(leftFruit,mp.get(leftFruit)-1);
                if(mp.get(leftFruit)==0){
                    mp.remove(leftFruit);
                }
                windowStart++;
            }
            maxLen=Math.max(maxLen,windowEnd-windowStart+1);
            windowEnd++;
        }
        return maxLen;
    }
}