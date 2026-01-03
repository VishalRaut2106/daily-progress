class Solution {

    // Merge two sorted linked lists using bottom pointer
    private Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node result;

        if (a.data <= b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }

        result.next = null; // IMPORTANT: remove next pointer
        return result;
    }

    // Flatten the linked list
    public Node flatten(Node root) {
        if (root == null || root.next == null) {
            return root;
        }

        // Flatten the rest of the list
        root.next = flatten(root.next);

        // Merge current list with flattened next list
        root = merge(root, root.next);

        return root;
    }
}