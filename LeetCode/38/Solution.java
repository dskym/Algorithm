class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for(int i=1;i<n;++i) {
            String temp = "";
            int count = 1;
            char c = result.charAt(0);
            for(int j=1;j<result.length();++j) {
                if(c == result.charAt(j)) {
                    count++;
                } else {
                    temp = temp + String.valueOf(count) + c;
                    c = result.charAt(j);
                    count = 1;
                }
            }
            temp = temp + String.valueOf(count) + c;
            result = temp;
        }
        return result;
    }
}
