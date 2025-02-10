class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();++i) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        String result = "";
        while(!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }
}
