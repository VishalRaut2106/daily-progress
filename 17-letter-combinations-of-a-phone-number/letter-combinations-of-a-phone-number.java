class Solution {
    private List<String> res = new ArrayList<>();
    private String[] map = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        if(digits.length() ==0) return res;
        backtrack(0,"" ,digits);
        return res;
        
    }
    private void backtrack(int i , String curstr , String digits){
        if(curstr.length() == digits.length()){
            res.add(curstr);
            return;
        }
        String chars = map[digits.charAt(i) - '0'];
        for(char c: chars.toCharArray()){
            backtrack(i+1, curstr +c,digits);
        }
    }
}