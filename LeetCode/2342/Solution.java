class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = -1;

        for(int num : nums) {
            int cnt = 0;
            int base = num;
            while(base != 0) {
                cnt += base % 10;
                base /= 10;
            }
            if(map.get(cnt) != null) {
                result = Math.max(result, map.get(cnt) + num);
                if(map.get(cnt) < num) {
                    map.put(cnt, num);
                }
            } else {
                map.put(cnt, num);
            }
        }

        return result;
    }
}
