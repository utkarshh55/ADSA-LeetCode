class Solution {
    public int maxVowels(String s, int k) {
        int count=0;
        int ans=0;

        for(int i=0;i<k;i++){
            char ch=s.charAt(i);
            if(isVowel(ch)){
                count++;
            }
        }
        ans=count;
        for(int i=k;i<s.length();i++){
            char chi=s.charAt(i);
            char chim=s.charAt(i-k);
            if(isVowel(chi)){
                count++;
            }
            if(isVowel(chim)){
                count--;
            }
            ans=Math.max(ans,count);
        }
        return ans;
    }
    public boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i'|| ch=='o'|| ch=='u'){
            return true;
        }else{
            return false;
        }
    }
}