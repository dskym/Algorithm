class Solution {
    public int maximumGain(String s, int x, int y) {
        int result = 0;

        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();++i) {
            char c = s.charAt(i);
            if(x > y) {
                if(!stack.isEmpty() && stack.peek() == 'a' && c == 'b') {
                    result += x;
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                if(!stack.isEmpty() && stack.peek() == 'b' && c == 'a') {
                    result += y;
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        Stack<Character> stack2 = new Stack<>();
        while(!stack.isEmpty()) {
            char c = stack.peek();
            stack.pop();
            if(x > y) {
                if(!stack2.isEmpty() && stack2.peek() == 'a' && c == 'b') {
                    result += y;
                    stack2.pop();
                } else {
                    stack2.push(c);
                }
            } else {
                if(!stack2.isEmpty() && stack2.peek() == 'b' && c == 'a') {
                    result += x;
                    stack2.pop();
                } else {
                    stack2.push(c);
                }
            }
        }
        return result;
    }
}

