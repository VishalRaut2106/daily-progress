class Solution {
    public int assignHole(int[] mices, int[] holes) {
        // code here
        Arrays.sort(mices);
        Arrays.sort(holes);
        int Ans = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < mices.length ; i++){
            int curr =Math.abs(mices[i] - holes[i]);
            Ans = Math.max(curr , Ans);
        }
        return Ans;
    }
};