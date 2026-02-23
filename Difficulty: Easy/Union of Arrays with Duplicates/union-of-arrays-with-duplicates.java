class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        
        HashSet<Integer> set = new HashSet<>();
        
        for (int x : a) set.add(x);
        for (int x : b) set.add(x);
        
        return new ArrayList<>(set);
    }
}