class Solution {
    public int maximumLength(String s) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();++i) {
            int index = i;
            while(index < s.length() && s.charAt(index) == s.charAt(i)) {
                String temp = s.substring(i, index+1);
                int count = map.getOrDefault(temp, 0)+1;
                map.put(temp, count);
                index++;
            }
        }

        int result = -1;
        for(String key : map.keySet()) {
            System.out.println(key + " : " + map.get(key));
            if(map.get(key) >= 3) {
                result = Math.max(result, key.length());
            }
        }
        return result;
    }
}
