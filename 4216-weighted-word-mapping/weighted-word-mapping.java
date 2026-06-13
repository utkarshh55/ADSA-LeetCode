class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder res=new StringBuilder();
        for(String word:words){
            int sum=0;
            for(char ch:word.toCharArray()){
                sum+=weights[ch-'a'];
            }
            int mod=sum%26;
            char map=(char)('z'-mod);
            res.append(map);
        }
        return res.toString();
    }
}