class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int a:asteroids){
            while(!st.empty() && a<0 && st.peek()>0){
                int sum=a+st.peek();
                if(sum<0){
                    st.pop();
                }else if(sum>0){
                    a=0;
                }else{
                    st.pop();
                    a=0;
                }
            }
            if(a!=0) st.push(a);
        }
        int s=st.size();
        int[] res=new int[s];
        int i=s-1;
        while(!st.empty()){
            res[i]=st.peek();
            st.pop();
            i--;
        }
        return res;
    }
}