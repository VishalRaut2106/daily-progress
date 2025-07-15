class Solution {//two pointer
        
          int max = 0,start = 0, end = 0;
    public boolean isPalindrome(String s , int i , int j){
      
        while (i < j){
            
            if(s.charAt(i)!=s.charAt(j)){
                return false;
                
            }
            i++;
            j--;
           
        }
            return true;
    }
    public String longestPalindrome(String s) {

        int n = s.length();
        for (int i = 0 ; i<n; i++){
            for (int j=i;j<n; j++){
                if(isPalindrome(s,i,j)==true){
                    if((j - i +1) > max){
                        max=j-i+1;
                        start =i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
}

// need to solve it again o(n^3)