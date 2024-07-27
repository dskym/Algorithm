class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] dist = new long[26][26];
        for(int i=0;i<26;++i) {
            for(int j=0;j<26;++j) {
                if(i == j) continue;
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<original.length;++i) {
            dist[original[i]-'a'][changed[i]-'a'] = Math.min(cost[i], dist[original[i]-'a'][changed[i]-'a']);
        }

        for(int k=0;k<26;++k) {
            for(int i=0;i<26;++i) {
                for(int j=0;j<26;++j) {
                    if(dist[i][k] < Integer.MAX_VALUE && dist[k][j] < Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][k]+dist[k][j], dist[i][j]);
                    }
                }
            }
        }

        long result = 0;
        for(int i=0;i<source.length();++i) {
            if(dist[source.charAt(i)-'a'][target.charAt(i)-'a'] == Integer.MAX_VALUE) {
                return -1;
            }
            result += dist[source.charAt(i)-'a'][target.charAt(i)-'a'];
        }
        return result;
    }
}
