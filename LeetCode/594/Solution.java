class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count+1);
        }

        int result = 0;
        for(int num : nums) {
            int a = map.getOrDefault(num, 0);
            int b = map.getOrDefault(num+1, 0);
            if(a != 0 && b != 0) {
                result = Math.max(result, a+b);
            }
        }
        return result;
    }
}
