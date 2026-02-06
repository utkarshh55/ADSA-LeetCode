class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> mp=new HashMap<>();
        int windowStart=0;
        int maxLen=0;
        for(int windowEnd=0;windowEnd<s.length();windowEnd++){
            char curr=s.charAt(windowEnd);
            mp.put(curr,mp.getOrDefault(curr,0)+1);
            while (mp.get(curr) > 1) {
                char leftChar = s.charAt(windowStart);
                mp.put(leftChar, mp.get(leftChar) - 1);
                windowStart++;
            }
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }
     return maxLen;
    }
}