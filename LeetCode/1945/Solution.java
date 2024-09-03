class Solution {
    public int getLucky(String s, int k) {
        String temp = "";
        for(int i=0;i<s.length();++i) {
            char c = s.charAt(i);
            temp += String.valueOf(c-'a'+1);
        }

        int result = 0;
        for(int i=0;i<k;++i) {
            int t = 0;
            for(int j=0;j<temp.length();++j) {
                t += temp.charAt(j)-'0';
            }
            temp = String.valueOf(t);
            result = t;
        }
        return result;
    }
}
