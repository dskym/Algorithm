class Solution {
    public int possibleStringCount(String word) {
        int result = 1;
        int temp = 0;
        char before = '0';
        for(int i=0;i<word.length();++i) {
            if(word.charAt(i) == before) {
                temp++;
            } else {
                before = word.charAt(i);
                result += temp;
                temp = 0;
            }
        }
        result += temp;
        return result;
    }
}
