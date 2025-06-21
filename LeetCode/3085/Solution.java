class Solution {
    public int minimumDeletions(String word, int k) {
        int[] count = new int[26];
        for(int i=0;i<word.length();++i) {
            count[word.charAt(i)-'a']++;
        }
        int result = Integer.MAX_VALUE;
        for(int i=0;i<26;++i) {
            int temp = 0;
            for(int j=0;j<26;++j) {
                if(count[j]-count[i] > k) {
                    temp += count[j]-count[i]-k;
                } else if(count[i] > count[j]) {
                    temp += count[j];
                }
            }
            result = Math.min(temp, result);
        }
        return result;
    }
}
