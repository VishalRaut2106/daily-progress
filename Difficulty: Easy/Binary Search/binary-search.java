class Solution {
    public int binarysearch(int[] arr, int k) {
        // Code Here
    if (arr == null || arr.length == 0 ) return -1;
    
    int start = 0, end = arr.length -1;
    int result = -1;
    
    
    while(start <=  end){
         int mid = start + (end - start )/2;
        
        if( arr[mid] ==k){
        result = mid ;
        end = mid -1;}
        else if(arr[mid] < k){
            start = mid +1;
            
        }
        else {
            end = mid -1;
        }
        
    }
       
       return result ;
    }
}