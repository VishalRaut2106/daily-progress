class Solution {
  public int maximumGain(String s, int x, int y) {
 
    return x > y ? gain(s, "ab", x, "ba", y) : gain(s, "ba", y, "ab", x);
  }

  private int gain(final String s, final String sub1, int point1, final String sub2, int point2) {
    int points = 0;
    Stack<Character> stack1 = new Stack<>();
    Stack<Character> stack2 = new Stack<>();

    for (final char c : s.toCharArray())
      if (!stack1.isEmpty() && stack1.peek() == sub1.charAt(0) && c == sub1.charAt(1)) {
        stack1.pop();
        points += point1;
      } else {
        stack1.push(c);
      }

    for (final char c : stack1)
      if (!stack2.isEmpty() && stack2.peek() == sub2.charAt(0) && c == sub2.charAt(1)) {
        stack2.pop();
        points += point2;
      } else {
        stack2.push(c);
      }

    return points;
  }
}