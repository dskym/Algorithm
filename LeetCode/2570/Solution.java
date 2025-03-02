class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] num : nums1) {
            map.put(num[0], num[1]);
        }
        for(int[] num : nums2) {
            map.put(num[0], map.getOrDefault(num[0], 0)+num[1]);
        }

        int[][] result = new int[map.size()][2];
        int index = 0;
        for(int key : map.keySet()) {
            result[index][0] = key;
            result[index][1] = map.get(key);
            index++;
        }
        Arrays.sort(result, (a,b) -> a[0]-b[0]);
        return result;
    }
}
