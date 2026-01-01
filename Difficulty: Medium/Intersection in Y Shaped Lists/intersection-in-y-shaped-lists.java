class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        int len1 = getLength(head1);
        int len2 = getLength(head2);

        Node p1 = head1;
        Node p2 = head2;

        // Align both lists
        if (len1 > len2) {
            int diff = len1 - len2;
            while (diff-- > 0) p1 = p1.next;
        } else {
            int diff = len2 - len1;
            while (diff-- > 0) p2 = p2.next;
        }

        // Traverse together
        while (p1 != null && p2 != null) {
            if (p1 == p2) return p1;
            p1 = p1.next;
            p2 = p2.next;
        }

        return null; // won't happen as per problem statement
    }

    private int getLength(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}