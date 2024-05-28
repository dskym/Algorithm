class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] count = new int[100001];
        for(int i=0;i<s.length();++i) {
            count[i] = Math.abs(s.charAt(i)-t.charAt(i));
        }

        int start = 0;
        int end = 0;

        int result = 0;
        int cost = 0;
        while(end < s.length()) {
            cost += count[end++];
            while(cost > maxCost) {
                cost -= count[start++];
            }
            result = Math.max(result, end-start);
        }
        return result;
    }
}
