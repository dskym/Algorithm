class Solution {
    public String clearStars(String s) {
        int[] count = new int[26];
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((a,b)->a.getKey() == b.getKey() ? b.getValue()-a.getValue() : a.getKey()-b.getKey());
        boolean[] isValid = new boolean[s.length()];

        for(int i=0;i<s.length();++i) {
            if(s.charAt(i) == '*') {
                Pair<Character, Integer> p = pq.poll();
                int c = p.getKey();
                int index = p.getValue();

                count[c-'a']--;

                isValid[index] = false;
            } else {
                count[s.charAt(i)-'a']++;
                pq.add(new Pair(s.charAt(i), i));
                isValid[i] = true;
            }
        }

        String result = "";
        for(int i=0;i<s.length();++i) {
            if(isValid[i]) {
                result += s.charAt(i);
            }
        }
        return result;
    }
}
