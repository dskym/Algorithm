class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for(int i=0;i<s.length();++i) {
            last[s.charAt(i)-'a'] = i;
        }

        int start = 0;
        int before = -1;
        List<Integer> result = new ArrayList<>();
        for(int end=0;end<s.length();++end) {
            int index = last[s.charAt(end)-'a'];
            while(start < index) {
                index = Math.max(last[s.charAt(start)-'a'], index);                
                start++;
            }
            end = start;
            result.add(start-before);
            before = start;
        }
        return result;
    }
}
