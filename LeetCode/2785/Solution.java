class Solution {
    public String sortVowels(String s) {
        Set<Character> vowels = Set.of('a','e','i','o','u', 'A', 'E', 'I', 'O', 'U');
        String temp = "";
        for(int i=0;i<s.length();++i) {
            char c = s.charAt(i);
            if(vowels.contains(c)) {
                temp += c;
            }
        }

        char[] t = temp.toCharArray();

        Arrays.sort(t);

        StringBuilder result = new StringBuilder();
        int index = 0;

        for(int i=0;i<s.length();++i) {
            char c = s.charAt(i);
            if(vowels.contains(c)) {
                result.append(t[index++]);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
