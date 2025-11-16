class Solution {
    public int numSub(String s) {
        int[] count = new int[100001];
        for(int i=1;i<=100000;++i) {
            count[i] = (i + count[i-1]) % 1000000007;
        }

        int result = 0;
        int c = 0;
        for(int i=0;i<s.length();++i) {
            if(s.charAt(i) == '0') {
                result = (result + count[c]) % 1000000007;
                c = 0;
            } else {
                c++;
            }
        }
        result = (result + count[c]) % 1000000007;
        return result;
    }
}
