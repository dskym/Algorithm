class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> Character.compare(b, a));
        int[] counter = new int[26];
        for(int i=0;i<s.length();++i) {
            if(counter[s.charAt(i)-'a'] == 0) {
                pq.add(s.charAt(i));
            }
            counter[s.charAt(i)-'a']++;
        }

        StringBuilder result = new StringBuilder();
        int count = 0;
        int diff = '0';
        while(!pq.isEmpty()) {
            char c = pq.poll();

            if(c == diff) {
                if(count >= repeatLimit) {
                    if(pq.isEmpty()) {
                        return result.toString();
                    } else {
                        char newC = pq.poll();
                        count = 1;
                        diff = newC;
                        counter[newC-'a']--;
                        if(counter[newC-'a'] > 0) {
                            pq.add(newC);
                        }
                        pq.add(c);
                        result.append(newC);
                    }
                } else {
                    count++;
                    counter[c-'a']--;
                    if(counter[c-'a'] > 0) {
                        pq.add(c);
                    }
                    result.append(c);
                }
            } else {
                count = 1;
                diff = c;
                counter[c-'a']--;
                if(counter[c-'a'] > 0) {
                    pq.add(c);
                }
                result.append(c);
            }
        }
        return result.toString();
    }
}
