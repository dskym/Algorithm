class Solution {
    public String compressedString(String word) {
        String result = "";
        char temp = word.charAt(0);
        int count = 1;
        for(int i=1;i<word.length();++i) {
            char c = word.charAt(i);
            if(c == temp && count < 9) {
                count++;
            } else {
                result += String.valueOf(count) + temp;
                temp = c;
                count = 1;
            }
        }
        result += String.valueOf(count) + temp;
        return result;
    }
}
