class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }

        for(int i=0;i<s.length();++i) {
            int count = 0;
            for(int j=0;j<goal.length();++j) {
                if(s.charAt(j) != goal.charAt((i+j)%goal.length())) {
                    break;                    
                }
                count++;
            }
            if(count == goal.length()) {
                return true;
            }
        }

        return false;
    }
}
