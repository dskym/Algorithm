class Solution {
    public String smallestNumber(String pattern) {
        int num = 1;
        int dec = 0;
        String result = "";
        for(int i=0;i<pattern.length();++i) {
            if(pattern.charAt(i) == 'I') {
                for(int j=0;j<dec;++j) {
                    result += String.valueOf(num-j);
                }
                result += String.valueOf(num-dec);
                dec = 0;
            } else {
                dec++;
            }
            num++;
        }
        for(int i=0;i<dec+1;++i) {
            result += String.valueOf(num-i);
        }
        return result;
    }
}
