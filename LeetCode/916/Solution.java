class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] diff = new int[26];
        for(String word : words2) {
            int[] count = new int[26];
            for(int i=0;i<word.length();++i) {
                count[word.charAt(i)-'a']++;
            }
            for(int i=0;i<26;++i) {
                diff[i] = Math.max(diff[i], count[i]);
            }
        }

        List<String> result = new ArrayList<>(); 
        for(String word : words1) {
            int[] count = new int[26];
            for(int i=0;i<word.length();++i) {
                count[word.charAt(i)-'a']++;
            }
            boolean flag = true;
            for(int i=0;i<26;++i) {
                if(diff[i] > count[i]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                result.add(word);
            }
        }
        return result;
    }
}
