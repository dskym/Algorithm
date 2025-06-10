class Solution {
    public int maxDifference(String s) {
        int[] count = new int[26];
        for(int i=0;i<s.length();++i) {
            count[s.charAt(i)-'a']++;
        }

        int a = 0;
        int b = Integer.MAX_VALUE;
        for(int i=0;i<26;++i) {
            if(count[i] == 0) {
                continue;
            }
            
            if(count[i] % 2 == 1 && a < count[i]) {
                a = count[i];
            }
            if(count[i] % 2 == 0 && b > count[i]) {
                b = count[i];
            }
        }
        return a - b;
    }
}
