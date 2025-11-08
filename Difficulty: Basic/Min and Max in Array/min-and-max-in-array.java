class Solution {
    public ArrayList<Integer> getMinMax(int[] arr) {
        // code Here
     int min = Integer.MAX_VALUE;
     int max = Integer.MIN_VALUE;
     
     
     for (int num :arr){
         if (num < min) min = num;
         if(num > max) max = num;
     }
     ArrayList<Integer> result = new ArrayList<>();
     
     result.add(min);
     result.add(max);
     return result;
    }
   
}
