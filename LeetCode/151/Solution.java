class Solution {
    public String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        String temp = "";
        for(int i=0;i<s.length();++i) {
            System.out.println(temp);
            if(' ' == s.charAt(i)) {
                if("".equals(temp) == false) {
                    words.add(temp);
                    temp = "";
                }
            } else {
                temp += s.charAt(i);
            }
        }
        if("".equals(temp) == false) {
            words.add(temp);
        }

        return String.join(" ", words.reversed());
    }
}
