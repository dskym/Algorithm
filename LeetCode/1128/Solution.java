class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] domino : dominoes) {
            int key = domino[0] > domino[1] ? domino[0]*10+domino[1] : domino[1]*10+domino[0];
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        int result = 0;
        for(int key : map.keySet()) {
            int count = map.get(key);
            result += (count-1) * count / 2;
        }
        return result;
    }
}
