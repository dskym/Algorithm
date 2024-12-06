class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> ban = new HashSet<>();
        for(int b : banned) {
            ban.add(b);
        }

        int sum = 0;
        int result = 0;
        for(int i=1;i<=n;++i) {
            if(ban.contains(i)) {
                continue;
            }
            sum += i;
            if(sum <= maxSum) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }
}
