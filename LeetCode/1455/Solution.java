class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] wordList = sentence.split(" ");
        int index = 1;
        for(String word : wordList) {
            boolean flag = true;
            for(int j=0;j<searchWord.length();++j) {
                if(j >= word.length() || searchWord.charAt(j) != word.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                return index++;
            }
            index++;
        }
        return -1;
    }
}
