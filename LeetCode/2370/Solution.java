class Solution {
    public int longestIdealString(String s, int k) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i=s.length()-1;i>=0;--i) {
            char c = s.charAt(i);
            int len = 1;
            for(int j=-k;j<=k;++j) {
                char temp = (char)(c+j);
                if(temp >= 'a' && temp <= 'z') {
                    if(map.containsKey(temp)) {
                        len = Math.max(len, map.get(temp)+1);
                    }
                }
            }
            if(map.containsKey(c)) {
                map.put(c, Math.max(map.get(c), len));
            } else {
                map.put(c, len);
            }
        }
        int result = 0;
        for(Character key : map.keySet()) {
            System.out.println(key + ", " + map.get(key));
            result = Math.max(result, map.get(key));
        }
        return result;
    }
}
