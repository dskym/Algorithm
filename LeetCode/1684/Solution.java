class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> s = new HashSet<>();
        for(int i=0;i<allowed.length();++i) {
            s.add(allowed.charAt(i));
        }

        int result = 0;
        for(int i=0;i<words.length;++i) {
            boolean flag = true;
            for(int j=0;j<words[i].length();++j) {
                if(s.contains(words[i].charAt(j)) == false) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                result++;
            }
        }
        return result;
    }
}
