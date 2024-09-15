class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        int[] prefix = new int[n];
        int temp = 0;
        for(int i=0;i<n;++i) {
            switch(s.charAt(i)) {
                case 'a' -> temp ^= 16;
                case 'e' -> temp ^= 8;
                case 'i' -> temp ^= 4;
                case 'o' -> temp ^= 2;
                case 'u' -> temp ^= 1;
            }
            prefix[i] = temp;
        }

        int result = 0;
        for(int i=n-1;i>=0;--i) {
            if(prefix[i] == 0) {
                result = Math.max(result, i+1);
                break;
            }
        }
        for(int i=1;i<n;++i) {
            for(int j=n-1;j>=i;--j) {
                if((prefix[j] ^ prefix[i-1]) == 0) {
                    result = Math.max(result, j-i+1);
                    break;
                }
            }
        }
        return result;
    }
}
