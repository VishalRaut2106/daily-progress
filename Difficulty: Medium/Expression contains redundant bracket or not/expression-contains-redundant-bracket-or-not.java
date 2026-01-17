class Solution {
    public static boolean checkRedundancy(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            // Push everything except closing bracket
            if (ch != ')') {
                stack.push(ch);
            } else {
                boolean hasOperator = false;

                // Pop until opening bracket
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char top = stack.pop();
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        hasOperator = true;
                    }
                }

                // Pop '('
                stack.pop();

                // No operator found → redundant
                if (!hasOperator) {
                    return true;
                }
            }
        }
        return false;
    }
}