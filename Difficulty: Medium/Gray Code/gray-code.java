class Solution {
    public ArrayList<String> graycode(int n) {
        ArrayList<String> result = new ArrayList<>();
        int total = 1 << n;

        for (int i = 0; i < total; i++) {
            int gray = i ^ (i >> 1);
            result.add(toBinary(gray, n));
        }

        return result;
    }

    private String toBinary(int num, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            sb.append((num >> i) & 1);
        }
        return sb.toString();
    }
}