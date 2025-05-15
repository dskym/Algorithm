class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = groups.length;

        List<String> result = new ArrayList<>();
        int last = -1;
        for(int i=0;i<n;++i) {
            if(groups[i] != last) {
                result.add(words[i]);
                last = groups[i];
            }
        }
        return result;
    }
}
