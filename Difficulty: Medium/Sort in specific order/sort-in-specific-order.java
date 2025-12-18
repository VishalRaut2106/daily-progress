class Solution {
    public void sortIt(int[] arr) {
        // code here
        int  n = arr.length;
        
        int left = 0 , right = n -1;
        
        
        while (left <= right){
            if(arr[left] % 2 ==1){
                left++;
            }else if(arr[right]% 2==0){
                right--;
            }else{
                int temp =arr[left];
                arr[left] = arr[right];
                arr[right] =temp;
                left++;
                right--;
            }
        }
        int oddCount = left;
        Arrays.sort(arr,0,oddCount);
        Arrays.sort(arr , oddCount , n);
        
        int i = 0 , j=oddCount-1;
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            
            i++;
            j--;
        }
    }
}
