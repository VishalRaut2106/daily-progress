class Solution {
  public:
    bool checkSorted(vector<int>& arr) {
        // code here
        int n  = arr.size();
        int spcount = 0;
        
        
        for (int i =0 ; i<n ; i++){
            if(arr[i]== i+1) continue ;
            while(arr[i]!= i+ 1){
                swap(arr[arr[i]-1], arr[i]);
                spcount++;
            }
        }
        return ( spcount ==2 || spcount ==0);
    }
};
