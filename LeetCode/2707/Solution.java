class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        for(String word : dictionary) {
            set.add(word);
        }

        int n = s.length();
        int[] dp = new int[n+1];
        for(int i=0;i<=n;++i) {
            dp[i]=n;
        }
        dp[0] = 0;

        for(int i=1;i<=n;++i) {
            for(int j=0;j<i;++j) {
                String substr = s.substring(j, i);
                if(set.contains(substr)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
            dp[i] = Math.min(dp[i], dp[i-1]+1);
        }
        return dp[n];
    }
}
