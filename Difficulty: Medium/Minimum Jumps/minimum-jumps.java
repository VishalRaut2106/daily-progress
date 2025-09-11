class Solution {
    public int minJumps(int[] arr) {
        // code here
        int n = arr.length , jump = 0,far = 0,end = 0;
        
       for (int  i = 0 ; i < n -1 ; i++){
           
           far = Math.max(far , i + arr[i]);
           
           if(i == end){
               jump++;
               end = far;
           }
           if( end >= n -1) return jump;
           
       }
       return -1;
    }
}