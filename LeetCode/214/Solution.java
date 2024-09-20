class Solution {
    public String shortestPalindrome(String s) {
        String sr = new StringBuffer(s).reverse().toString();
        for(int i=0;i<sr.length();++i) {
            if(s.startsWith(sr.substring(i))) {
                return sr.substring(0, i)+s;
            }
        }
        return sr+s;
    }
}
