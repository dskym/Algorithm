class Solution {
    public int maxScore(String s) {
        int left = 0;
        int right = 0;

        if(s.charAt(0) == '0') {
            left++;
        }

        for(int i=1;i<s.length();++i) {
            if(s.charAt(i) == '1') {
                right++;
            }
        }

        int result = left+right;
        for(int i=1;i<s.length()-1;++i) {
            if(s.charAt(i) == '0') {
                left++;
            }
            if(s.charAt(i) == '1') {
                right--;
            }
            result = Math.max(result, left+right);
        }
        return result;
    }
}
