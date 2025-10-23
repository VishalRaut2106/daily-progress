class Solution {
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        Arrays.sort(points, (a, b) ->
            (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1])
        );

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(points[i][0]);
            temp.add(points[i][1]);
            res.add(temp);
        }

        return res;
    }
}
