class Solution {
    class Pair{
        String s;
        int dist;
        Pair(String s,int dist){
            this.s=s;
            this.dist=dist;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> st = new HashSet<>(wordList);
        if(!st.contains(endWord)) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        st.remove(beginWord);
        while(!q.isEmpty()){
            Pair p=q.poll();
            String curword=p.s;
            int curdist=p.dist;
            if(curword.equals(endWord)){
                return curdist;
            }
            char[] wordArr = curword.toCharArray();
            for(int i=0;i<wordArr.length;i++){
                char original = wordArr[i];
                for(char ch='a'; ch<='z'; ch++){
                    wordArr[i]=ch;
                    String temp=new String(wordArr);
                    if(st.contains(temp)){
                        q.add(new Pair(temp,curdist+1));
                        st.remove(temp);  
                    }
                }
                wordArr[i]=original;
            }
        }
        return 0;
    }
}