class Solution {
    public int minChanges(String s) {
        int result = 0;
        for(int i=0;i<s.length()/2;++i) {
            if(s.charAt(2*i) != s.charAt(2*i+1)) {
                result++;
            }
        }
        return result;
    }
}
