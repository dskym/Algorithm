class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        String[] sortedWords = new String[n];

        for(int i=0;i<n;++i) {
            char[] c = words[i].toCharArray();
            Arrays.sort(c);
            sortedWords[i] = new String(c);
        }

        List<String> result = new ArrayList<>();
        result.add(words[0]);
        for(int i=1;i<n;++i) {
            if(sortedWords[i].equals(sortedWords[i-1])) {
                continue;
            }
            result.add(words[i]);
        }
        return result;
    }
}
