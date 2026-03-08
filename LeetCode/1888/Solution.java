class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String temp = s + s;

        int result = n;
        result = Math.min(solve(temp, n, '0', '1'), result);
        result = Math.min(solve(temp, n, '1', '0'), result);
        return result;
    }

    private int solve(String s, int n, char start, char end) {
        int result = s.length();
        int count = 0;
        for(int i=0;i<s.length();++i) {
            char expect = (i % 2 == 0) ? start : end;
            if(s.charAt(i) != expect) {
                count++;
            }
            if(i >= n) {
                char prev = ((i-n) % 2 == 0) ? start : end;
                if(prev != s.charAt(i-n)) {
                    count--;
                }
            }
            if(i >= n-1) {
                result = Math.min(result, count);
            }
        }
        return result;
    }
}
