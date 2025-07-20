import java.util.*;

public class Solution {
    class TrieNode {
        String name;
        boolean toDelete = false;
        Map<String, TrieNode> children = new HashMap<>();

        TrieNode(String name) {
            this.name = name;
        }
    }

    // Insert a folder path into the Trie
    private void insert(TrieNode root, List<String> path) {
        for (String folder : path) {
            root.children.putIfAbsent(folder, new TrieNode(folder));
            root = root.children.get(folder);
        }
    }

    // Post-order traversal: Serialize children structure and mark duplicates
    private String serialize(TrieNode node, Map<String, List<TrieNode>> map) {
        if (node.children.isEmpty()) return "";

        List<String> serializedChildren = new ArrayList<>();
        for (String key : node.children.keySet()) {
            serializedChildren.add(key + serialize(node.children.get(key), map));
        }

        Collections.sort(serializedChildren);  // Ensure consistent structure
        String serial = String.join("", serializedChildren);

        map.computeIfAbsent(serial, k -> new ArrayList<>()).add(node);
        return "(" + serial + ")";
    }

    // DFS to collect non-deleted paths
    private void collect(TrieNode node, List<String> path, List<List<String>> result) {
        for (TrieNode child : node.children.values()) {
            if (!child.toDelete) {
                path.add(child.name);
                result.add(new ArrayList<>(path));
                collect(child, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        TrieNode root = new TrieNode("");

        // Step 1: Build Trie
        for (List<String> path : paths) {
            insert(root, path);
        }

        // Step 2: Serialize subtrees
        Map<String, List<TrieNode>> map = new HashMap<>();
        serialize(root, map);

        // Step 3: Mark duplicates for deletion
        for (List<TrieNode> group : map.values()) {
            if (group.size() > 1) {
                for (TrieNode node : group) {
                    node.toDelete = true;
                }
            }
        }

        // Step 4: Collect remaining paths
        List<List<String>> result = new ArrayList<>();
        collect(root, new ArrayList<>(), result);
        return result;
    }

    // Optional main method to test
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<String>> input = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("c"),
                Arrays.asList("d"),
                Arrays.asList("a", "b"),
                Arrays.asList("c", "b"),
                Arrays.asList("d", "a")
        );

        List<List<String>> result = sol.deleteDuplicateFolder(input);
        for (List<String> path : result) {
            System.out.println(path);
        }
    }
}
