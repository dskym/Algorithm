class Solution {
    private List<String> result = new ArrayList();
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Character, List<String>> wordMap = new HashMap<>();
        for(String word : wordDict) {
            List<String> wordList = wordMap.getOrDefault(word.charAt(0), new ArrayList<>());
            wordList.add(word);
            wordMap.put(word.charAt(0), wordList);
        }
        solve(s, wordMap, new ArrayList<String>());
        return result;
    }

    public void solve(String s, Map<Character, List<String>> wordMap, List<String> temp) {
        if(s.length() == 0) {
            result.add(String.join(" ", temp));
            return;
        }

        List<String> list = wordMap.get(s.charAt(0));
        if(list == null) {
            return;
        }
        for(String str : list) {
            if(s.length() < str.length()) {
                continue;
            }
            String c = s.substring(0, str.length());
            if(c.equals(str)) {
                temp.add(str);
                solve(s.substring(str.length()), wordMap, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}
