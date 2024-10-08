class Solution {
    public int minSwaps(String s) {
        int open = 0;
        int close = 0;

        int end = s.length()-1;

        int result = 0;

        for(int i=0;i<=end;++i) {
            if(s.charAt(i) == ']') {
                close++;
            } else if(s.charAt(i) == '[') {
                open++;
            }

            if(close > open) {
                while(s.charAt(end) != '[') {
                    end--;
                }
                close--;
                open++;
                result++;
            }
        }

        return result;
    }
}
