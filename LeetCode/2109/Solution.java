class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();

        int index = 0;
        for(int i=0;i<spaces.length;++i) {
            result.append(s.substring(index, spaces[i]));
            result.append(" ");
            index = spaces[i];
        }
        result.append(s.substring(index));
        return result.toString();
    }
}
