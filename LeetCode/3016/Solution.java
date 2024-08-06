class Solution {
    public int minimumPushes(String word) {
        int[] count = new int[26];

        for(int i=0;i<word.length();++i) {
            count[word.charAt(i)-'a']++;
        }

        Arrays.sort(count);

        int result = 0;
        for(int i=0;i<26;++i) {
            result += count[25-i] * (1+(i/8));
        }
        return result;
    }
}
