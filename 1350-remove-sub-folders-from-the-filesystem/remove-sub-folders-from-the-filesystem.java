import java.util.*;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);  // Sort all paths lexicographically
        List<String> res = new ArrayList<>();
        
        for (String f : folder) {
            // Check if it's a sub-folder of the last folder in res
            if (res.isEmpty() || !f.startsWith(res.get(res.size() - 1) + "/")) {
                res.add(f);
            }
        }
        
        return res;
    }
}
