class Solution {
    public int minimumLength(String s) {
        int[] count = new int[26];
        for(int i=0;i<s.length();++i) {
            count[s.charAt(i)-'a']++;
        }

        int result = 0;
        for(int i=0;i<26;++i) {
            if(count[i] == 0) {
                continue;
            }
            
            if(count[i] % 2 == 1) {
                result+=1;
            } else if(count[i] % 2 == 0) {
                result+=2;
            }
        }
        return result;
    }
}
