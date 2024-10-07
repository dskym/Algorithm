class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();++i) {
            if(stack.isEmpty() == false) {
                if((s.charAt(i) == 'D' && stack.peek() == 'C')
                || (s.charAt(i) == 'B' && stack.peek() == 'A')){
                    stack.pop();
                    continue;
                }
            }
            stack.push(s.charAt(i));
        }
        return stack.size();
    }
}
