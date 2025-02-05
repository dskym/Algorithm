class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }

        int[] count = new int[26];
        int diff = 0;
        for(int i=0;i<s1.length();++i) {
            if(s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
            count[s1.charAt(i)-'a']++;
            count[s2.charAt(i)-'a']--;
        }

        for(int i=0;i<26;++i) {
            if(count[i] != 0) {
                return false;
            }
        }

        return diff <= 2;
    }
}
