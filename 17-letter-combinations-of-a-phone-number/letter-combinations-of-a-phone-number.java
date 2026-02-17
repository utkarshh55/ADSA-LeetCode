class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if(digits==null ||digits.length()==0){
            return res;
        }
        HashMap<Character,String> mp=new HashMap<>();
        mp.put('2',"abc");
        mp.put('3',"def");
        mp.put('4',"ghi");
        mp.put('5',"jkl");
        mp.put('6',"mno");
        mp.put('7',"pqrs");
        mp.put('8',"tuv");
        mp.put('9',"wxyz");
        backtrack(res,digits,mp,0,new StringBuilder());
        return res;
    }
    public void backtrack(List<String> res,String digits,HashMap<Character,String> mp,int idx,StringBuilder curr){
        if(idx==digits.length()){
            res.add(curr.toString());
            return;
        }
        String letters=mp.get(digits.charAt(idx));
        for(char ch:letters.toCharArray()){
            curr.append(ch);
            backtrack(res,digits,mp,idx+1,curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}