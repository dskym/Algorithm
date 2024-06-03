class Solution {
    public int appendCharacters(String s, String t) {
        int pos = 0;
        int curr = 0;

        while(pos < t.length() && curr < s.length()) {
            if(t.charAt(pos) == s.charAt(curr)) {
                pos++;
            }
            curr++;
        }

        return t.length()-pos;
    }
}
