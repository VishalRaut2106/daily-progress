class Solution {
    public void rearrangeQueue(Queue<Integer> q) {

        int n = q.size();
        int half = n / 2;

        Queue<Integer> firstHalf = new LinkedList<>();

        
        for (int i = 0; i < half; i++) {
            firstHalf.add(q.poll());
        }

       
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.poll());  
            q.add(q.poll());          // element from second 
        }
    }
}
