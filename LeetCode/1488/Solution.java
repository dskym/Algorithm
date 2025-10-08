class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;

        Map<Integer, Integer> rainIndex = new HashMap<>();
        TreeSet<Integer> st = new TreeSet<Integer>();
        int[] result = new int[n];
        Arrays.fill(result, 1);
        for(int i=0;i<n;++i) {
            if(rains[i] != 0) {
                if(rainIndex.containsKey(rains[i])) {
                    Integer it = st.ceiling(rainIndex.get(rains[i]));
                    if (it == null) {
                        return new int[0];
                    }
                    result[it] = rains[i];
                    st.remove(it);
                }
                result[i] = -1;
                rainIndex.put(rains[i], i);
            } else {
                st.add(i);
            }
        }
        return result;
    }
}
