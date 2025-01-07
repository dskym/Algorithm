class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        for(String word1 : words) {
            for(String word2 : words) {
                if(word1.equals(word2) == false && word2.indexOf(word1) != -1) {
                    result.add(word1);
                    break;
                }
            }
        }
        return result;
    }
}
