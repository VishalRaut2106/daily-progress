class Solution {

    private StringBuilder doc = new StringBuilder();
    private Stack<Character> undoStack = new Stack<>();

    public void append(char x) {
        doc.append(x);
        undoStack.clear(); // redo history invalid after new append
    }

    public void undo() {
        if (doc.length() > 0) {
            char removed = doc.charAt(doc.length() - 1);
            doc.deleteCharAt(doc.length() - 1);
            undoStack.push(removed);
        }
    }

    public void redo() {
        if (!undoStack.isEmpty()) {
            char ch = undoStack.pop();
            doc.append(ch);
        }
    }

    public String read() {
        return doc.toString();
    }
}