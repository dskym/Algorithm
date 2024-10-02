class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] temp = arr.clone();
        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for(int i=0;i<n;++i) {
            if(map.containsKey(temp[i]) == false) {
                map.put(temp[i], count++);
            }
        }

        int[] result = new int[n];
        for(int i=0;i<n;++i) {
            result[i] = map.get(arr[i]);
        }
        return result;
    }
}
