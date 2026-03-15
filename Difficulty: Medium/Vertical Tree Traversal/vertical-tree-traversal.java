class Pair {
    Node node;
    int hd;

    Pair(Node n, int h) {
        node = n;
        hd = h;
    }
}

class Solution {
    static ArrayList<ArrayList<Integer>> verticalOrder(Node root) {

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();

        int min = 0, max = 0;

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node cur = p.node;
            int hd = p.hd;

            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(cur.data);

            min = Math.min(min, hd);
            max = Math.max(max, hd);

            if (cur.left != null)
                q.add(new Pair(cur.left, hd - 1));

            if (cur.right != null)
                q.add(new Pair(cur.right, hd + 1));
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = min; i <= max; i++)
            ans.add(map.get(i));

        return ans;
    }
}