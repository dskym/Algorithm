class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int[][] dp = new int[1001][1001];
        Map<Integer, Integer> map = new HashMap<>();

        int result = 0;
        for(int i=0;i<arr.length;++i) {
            map.put(arr[i], i);
            for(int j=0;j<i;++j) {
                int diff = arr[i]-arr[j];
                int prevIndex = map.getOrDefault(diff, -1);

                if(diff < arr[j] && prevIndex >= 0) {
                    dp[j][i] = dp[prevIndex][j]+1;
                } else {
                    dp[j][i] = 2;
                }

                result = Math.max(result, dp[j][i]);
            }
        }
        return (result > 2 ? result : 0);
    }
}
