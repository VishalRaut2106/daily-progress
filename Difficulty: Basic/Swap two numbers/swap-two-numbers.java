class Solution {
    static List<Integer> get(int a, int b) {
        int t = a;
        a = b;
        b = t;
        
        List<Integer> res = new ArrayList<>();
        res.add(a);
        res.add(b);
        
        return res;
    }
}