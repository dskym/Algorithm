class Solution {
    public char kthCharacter(int k) {
        String result = "a";
        while(true) {
            if(k <= result.length()) {
                return result.charAt(k-1);
            }
            String temp = "";
            for(int i=0;i<result.length();++i) {
                temp += (char)((result.charAt(i)-'a'+1)%26+'a');
            }
            result += temp;
        }
    }
}
