class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int start = 0;
        int end = 0;
        int result = 0;
        while(end < n) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0)+1);
            while(map.size() == 3) {
                result += n-end;
                map.put(s.charAt(start), map.get(s.charAt(start))-1);
                if(map.get(s.charAt(start)) == 0) {
                    map.remove(s.charAt(start));
                }
                start++;
            }
            end++;
        }
        return result;
    }
}
