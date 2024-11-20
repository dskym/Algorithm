class Solution {
    public int takeCharacters(String s, int k) {
        int[] counter = new int[3];
        for(int i=0;i<s.length();++i) {
            counter[s.charAt(i)-'a']++;
        }

        if(check(counter, k) == false) {
            return -1;
        }

        int start = 0;
        int end = 0;

        int result = -1;
        while(end < s.length()) {
            counter[s.charAt(end)-'a']--;

            while(check(counter, k) == false && start <= end) {
                counter[s.charAt(start)-'a']++;
                start++;
            }
            result = Math.max(result, end-start+1);
            end++;
        }

        return s.length()-result;
    }

    private boolean check(int[] counter, int k) {
        for(int i=0;i<3;++i) {
            if(counter[i] < k) {
                return false;
            }
        }
        return true;
    }
}
