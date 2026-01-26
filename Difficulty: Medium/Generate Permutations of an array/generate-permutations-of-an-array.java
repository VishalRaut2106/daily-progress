class Solution {
    
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(arr, 0, result);
        return result;
    }
    
    private static void backtrack(int[] arr, int index, ArrayList<ArrayList<Integer>> result) {
        // Base case: one full permutation formed
        if (index == arr.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int num : arr) {
                temp.add(num);
            }
            result.add(temp);
            return;
        }
        
        // Try placing every element at current index
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);        // choose
            backtrack(arr, index + 1, result); // explore
            swap(arr, index, i);        // un-choose (backtrack)
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}