class Solution {
    public int compress(char[] chars) {
        int index = 0;  // Position
        int i = 0;      // Read pointer

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            // Count 
            while (i < chars.length && chars[i] == currentChar) {
                count++;
                i++;
            }

            // Write the character
            chars[index++] = currentChar;

            // Write the count if more than 1
            if (count > 1) {
                String countStr = Integer.toString(count);
                for (char c : countStr.toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index; 
    }
}
