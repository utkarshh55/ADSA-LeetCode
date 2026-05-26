class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();
        for (String op : ops) {
            if (op.equals("C")) {
                if (!st.isEmpty()) st.pop();
            } 
            else if (op.equals("D")) {
                st.push(st.peek() * 2);
            } 
            else if (op.equals("+")) {
                int last = st.pop();
                int newScore = last + st.peek();
                st.push(last);      
                st.push(newScore);   
            } 
            else {
                st.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        for (int score : st) sum += score;
        return sum;
    }
}
