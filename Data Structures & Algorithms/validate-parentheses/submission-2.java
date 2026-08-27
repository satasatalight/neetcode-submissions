class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        for (char cur : s.toCharArray()) {
            Character peeked = stack.peek();

            switch (cur) {
                case '(':
                case '{':
                case '[':
                    stack.push(cur);
                    break;

                case ')':
                    if (peeked != null && peeked == '(')
                        stack.pop();
                    else
                        return false;
                    break;

                case '}':
                    if (peeked != null && peeked == '{')
                        stack.pop();
                    else 
                        return false;
                    break;

                case ']':
                    if (peeked != null && peeked == '[')
                        stack.pop();
                    else 
                        return false;
                    break;
            }
        }

        return stack.isEmpty();
    }
}
