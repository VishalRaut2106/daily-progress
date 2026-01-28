
class Solution {

    public int countSubset(int[] arr, int k) {
        int n = arr.length;

        
        int mid = n / 2;

        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, n);

       
        List<Integer> leftSums = getSubsetSums(left);
        List<Integer> rightSums = getSubsetSums(right);

        
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int sum : rightSums) {
            freqMap.put(sum, freqMap.getOrDefault(sum, 0) + 1);
        }

       
        int count = 0;
        for (int sumL : leftSums) {
            int need = k - sumL;
            count += freqMap.getOrDefault(need, 0);
        }

        return count;
    }

   
    private List<Integer> getSubsetSums(int[] part) {
        int m = part.length;
        List<Integer> sums = new ArrayList<>();

        int total = 1 << m; 

        for (int mask = 0; mask < total; mask++) {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += part[i];
                }
            }
            sums.add(sum);
        }

        return sums;
    }
}