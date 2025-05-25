class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> counter = new HashMap<>();
        for(String word : words) {
            counter.put(word, counter.getOrDefault(word, 0)+1);
        }

        int result = 0;
        boolean flag = false;
        for(String key : counter.keySet()) {
            String temp = String.valueOf(key.charAt(1))+String.valueOf(key.charAt(0));
            if(key.equals(temp)) {
                if(counter.get(key) >= 2) {
                    result += counter.get(key)/2*2;
                }
                if(counter.get(key) % 2 == 1) {
                    flag = true;
                }
            } else if(counter.get(key)>0 && counter.containsKey(temp) && counter.get(temp)>0) {
                result += Math.min(counter.get(key), counter.get(temp));
            }
        }
        if(flag) {
            result++;
        }
        return result*2;
    }
}
