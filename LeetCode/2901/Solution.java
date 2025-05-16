class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int[] prev = new int[n];

        Arrays.fill(dp, -1);
        Arrays.fill(prev, -1);

        int maxIndex = 0;
        for(int i=1;i<n;++i) {
            for(int j=0;j<i;++j) {
                if(check(words[i], words[j]) && dp[j]+1>dp[i] && groups[i] != groups[j]) {
                    dp[i] = dp[j]+1;
                    prev[i] = j;
                }
            }
            if(dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }

        List<String> result = new ArrayList<>();
        for(int i=maxIndex;i>=0;i=prev[i]) {
            result.add(words[i]);
        }
        Collections.reverse(result);
        return result;
    }

    private boolean check(String a, String b) {
        if(a.length() != b.length()) {
            return false;
        }

        int count = 0;
        for(int i=0;i<a.length();++i) {
            if(a.charAt(i) != b.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }
}
