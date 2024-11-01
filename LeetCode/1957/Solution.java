class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        char before = ' ';
        for(int i=0;i<s.length();++i) {
            if(s.charAt(i) == before) {
                count++;
            } else {
                count=0;
                before=s.charAt(i);
            }
            
            if(count >= 2) {
                continue;
            }

            result.append(s.charAt(i));
        }
        return result.toString();
    }
}
