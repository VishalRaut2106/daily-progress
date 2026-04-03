class Solution {
    public ArrayList<Integer> diagView(int[][] mat) {
        int n = mat.length;
        ArrayList<Integer> result = new ArrayList<>();

        for (int sum = 0; sum <= 2 * (n - 1); sum++) {
            for (int i = Math.max(0, sum - (n - 1)); i <= Math.min(n - 1, sum); i++) {
                int j = sum - i;
                result.add(mat[i][j]);
            }
        }

        return result;
    }
}