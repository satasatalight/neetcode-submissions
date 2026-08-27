class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        for (char cur : s.toCharArray()) {
            char opp = 'N';
            Character peeked = stack.peek();

            switch (cur) {
                case '(':
                case '{':
                case '[':
                    stack.push(cur);
                    continue;

                case ')':
                    opp = '(';
                    break;

                case '}':
                    opp = '{';
                    break;

                case ']':
                    opp = '[';
                    break;
            }

            if (peeked != null && peeked == opp)
                stack.pop();
            else 
                return false;
        }

        return stack.isEmpty();
    }
}
