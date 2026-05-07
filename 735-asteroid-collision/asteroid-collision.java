class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> ans=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        int n=asteroids.length;
        for(int i=0;i<n;i++){
            if(asteroids[i]>0){
                st.push(asteroids[i]);
            }
            else{
                while(!st.isEmpty() && st.peek()<Math.abs(asteroids[i])){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek()==Math.abs(asteroids[i])){
                    st.pop();
                    continue;
                }
                if(st.isEmpty()){
                    ans.add(asteroids[i]);
                }
            }
        }
        int stSize=st.size();
        int l=ans.size();
        int[] arr=new int[l+stSize];
        int k=l+stSize-1;
        for(int i=0;i<l;i++){
            arr[i]=ans.get(i);
        }
        while(!st.isEmpty()){
            arr[k--]=st.pop();
        }
        return arr;
    }
}