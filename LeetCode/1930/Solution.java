class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] firstIndex = new int[26];
        int[] lastIndex = new int[26];

        Arrays.fill(firstIndex, -1);
        Arrays.fill(lastIndex, -1);

        for(int i=0;i<s.length();++i) {
            if(firstIndex[s.charAt(i)-'a'] == -1) {
                firstIndex[s.charAt(i)-'a'] = i;
            }
            lastIndex[s.charAt(i)-'a'] = i;
        }

        int result = 0;
        for(int i=0;i<26;++i) {
            int first = firstIndex[i];
            int last = lastIndex[i];

            Set<Character> set = new HashSet<>();
            if(first != last) {
                for(int j=first+1;j<=last-1;++j) {
                    set.add(s.charAt(j));
                }
            }
            result += set.size();
        }
        return result;
    }
}
