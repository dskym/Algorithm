class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int mod = 1000000007;
        int[] count = new int[26];

        for(int i=0;i<s.length();++i) {
            count[s.charAt(i)-'a']++;
        }

        for(int i=0;i<t;++i) {
            int[] next = new int[26];
            next[0] = count[25];
            next[1] = (count[25] + count[0]) % mod;
            for(int j=2;j<26;++j) {
                next[j] = count[j-1];
            }
            count = next;
        }
        int result = 0;
        for(int i=0;i<26;++i) {
            result = (result+count[i]) % mod;
        }
        return result;
    }
}
