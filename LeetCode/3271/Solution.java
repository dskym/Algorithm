class Solution {
    public String stringHash(String s, int k) {
        String result = "";
        for(int i=0;i<s.length();i+=k) {
            int pos = 0;
            for(int j=0;j<k;++j) {
                pos += s.charAt(i+j)-'a';
            }
            result += (char)('a'+pos%26);
        }
        return result;
    }
}
